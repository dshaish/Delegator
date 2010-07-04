package org.domain.delegator.session;

import org.domain.delegator.entity.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.jboss.seam.Component;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.framework.EntityHome;
import org.jboss.seam.persistence.EntityManagerFactory;

import com.sun.org.apache.xerces.internal.impl.dv.dtd.ENTITYDatatypeValidator;

@Name("tasksHome")
public class TasksHome extends EntityHome<Tasks> {

	@In(create = true)
	EmployeeHome employeeHome;
	@In(create = true)
	TasksCHome tasksCHome;
	@In(create = true)
	UpdatesHome updatesHome;
	
	@In (create = false)
	LoggedUserBean loggedUser; 
	
	@In(value = "MarkedEmployee", create = true)
	@Out(value = "MarkedEmployee")
	public MarkedEmployee markedEmployee;
	
	public void setTasksTid(Integer id) {
		setId(id);
	}

	public Integer getTasksTid() {
		return (Integer) getId();
	}

	@Override
	protected Tasks createInstance() {
		Tasks tasks = new Tasks();
		tasks.setEmployee(loggedUser.getEmp());
		return tasks;
	}

	public void wire() {
		getInstance();
		Employee employee = employeeHome.getDefinedInstance();
		if (employee != null) {
			getInstance().setEmployee(employee);
		}
		TasksC tasksCByTid = tasksCHome.getDefinedInstance();
		if (tasksCByTid != null) {
			getInstance().setTasksCByTid(tasksCByTid);
		}
		Updates updates = updatesHome.getDefinedInstance();
		if (updates != null) {
			getInstance().setUpdates(updates);
		}
	}

	public boolean isWired() {
		if (getInstance().getEmployee() == null)
			return false;
		return true;
	}

	public Tasks getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<TasksC> getTasksCsForRootTaskId() {
		return getInstance() == null ? null : new ArrayList<TasksC>(
				getInstance().getTasksCsForRootTaskId());
	}
	public List<DoneBy> getDoneBies() {
		return getInstance() == null ? null : new ArrayList<DoneBy>(
				getInstance().getDoneBies());
	}

	public List<TasksC> getTasksCsForParentTaskId() {
		return getInstance() == null ? null : new ArrayList<TasksC>(
				getInstance().getTasksCsForParentTaskId());
	}
	
	public String managedPersist(){
		persist();
		
		Tasks currTask = this.getInstance();
		
		DoneById doneById = new DoneById(currTask.getTid(), loggedUser.get_UserEid());
		DoneBy doneBy = new DoneBy(doneById, currTask, loggedUser.getEmp(), (byte) 0);
		
		TasksC tasksC = new TasksC(currTask, currTask, currTask); 

		EntityManager em = this.getEntityManager();
		em.persist(doneBy);
		em.persist(tasksC);
		em.flush();
		
		delegateTask(em, currTask);
		
		return "s";
	}

	private boolean delegateTask(EntityManager em, Tasks parent) {
		
		Tasks delegatedTask;
				
		TasksC tasksC;
		
		Iterator<Integer> itr = markedEmployee.getMarkedList().iterator();
		Employee currEmp;
		DoneById doneById;
		DoneBy doneBy; 
		
		while (itr.hasNext()) {
			delegatedTask = new Tasks(loggedUser.getEmp(),
							null,null,null,
							parent.getTitle(), 
							parent.getStatus(),false,false);
			em.persist(delegatedTask);
			em.flush();
			
			tasksC = new TasksC(delegatedTask, parent, parent.getTasksCByTid().getTasksByRootTaskId());
			
			currEmp = em.find(Employee.class, itr.next());
			doneById = new DoneById(delegatedTask.getTid(), currEmp.getEid());
			doneBy = new DoneBy(doneById, delegatedTask, currEmp, (byte) 0);
			em.persist(doneBy);
			em.persist(tasksC);
			em.flush();
		}
		
		markedEmployee.clearMarkedList();
		return true;
		
	}
}
