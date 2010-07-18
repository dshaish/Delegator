package org.delegator.engine;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.xml.ws.WebServiceException;

import org.delegator.api.NubemetEmployee;
import org.delegator.api.NubemetTask;
import org.delegator.entities.DoneBy;
import org.delegator.entities.Employee;
import org.delegator.entities.Tasks;
import org.hibernate.Session;

class TasksList{
	
	public TasksList() {
	}

	/**
	 * Returns the tasks list according to the connected user and the filter type.
	 * @param filter filter type for the list extraction from the DB.
	 * @param userEid 
	 * @return the list of tasks for the user.
	 */
	@SuppressWarnings("unchecked")
	public List<NubemetTask> getTasks(Long userEid) {
		// Initialize base parameters
		Session hybssn = HibernateUtils.getSessionFactory().getCurrentSession();
		if (hybssn == null)
			throw new WebServiceException("No session in WebServiceContext");
		hybssn.beginTransaction();
		
		List<NubemetTask> tasksList = new LinkedList<NubemetTask>();
		
		// Run the query:
		Iterator<Tasks> results= (hybssn.createQuery(UserTasksFilter.getFilter(UserTasksFilter.ALL))
													.setParameter("userEid", userEid).list()).iterator();
		
		// Convert To API object
		while(results.hasNext()) {
			// Convert from Tasks entity to NubemetTask.
			Tasks curTask = (Tasks)results.next();
			NubemetTask curNubemetTask = new NubemetTask();
			curNubemetTask.setTitle(curTask.getTitle());
			curNubemetTask.setDescription(curTask.getDescription());
			curNubemetTask.setTid(curTask.getTid());
			curNubemetTask.setCdate(curTask.getcDate());
			curNubemetTask.setEdate(curTask.geteDate());
			curNubemetTask.setDelegated(curTask.getDelegated());
			tasksList.add(curNubemetTask);
		}
	
		hybssn.getTransaction().commit();
		return tasksList;
	}
	
	/**
	 * Adds a new task to the user's list.
	 * The delegation process is not done here!.
	 * @param newNubemetTask The new Task	 
	 * @param userEid 
	 * @return true on success, false else.
	 */
	public boolean addTask(NubemetTask newNubemetTask, Long userEid){
		Session hybssn = HibernateUtils.getSessionFactory().getCurrentSession();
		hybssn.beginTransaction();
		Employee emp = (Employee)hybssn
							.createQuery("from Employee where Eid = :userEid")
							.setParameter("userEid", userEid)
							.uniqueResult();
		
		
		// Converting Nubemet task to Task:
		Tasks newTask = new Tasks();
		newTask.setTitle(newNubemetTask.getTitle());
		newTask.setDescription(newNubemetTask.getDescription());
		newTask.setTid(newNubemetTask.getTid());
		newTask.setcDate(newNubemetTask.getCdate());
		newTask.setCreator(emp);
		newTask.seteDate(newNubemetTask.getEdate());
		newTask.setDelegated(newNubemetTask.getDelegated());
		newTask.setDelegated(newNubemetTask.getDelegated());

		// Linking with Done BY:
		DoneBy doneBy = new DoneBy();
		doneBy.setEmployee(emp);
		doneBy.setTask(newTask);
		
		// Adding a Done By record:
		newTask.addToDoneBy(doneBy);
		emp.addToDoneBy(doneBy);
		
		// save and commit changed objects
		hybssn.save(newTask);
		hybssn.save(emp);
		hybssn.getTransaction().commit();
		
		return true;
	}
	
	/**
	 * Returns a list of people who works for me.
	 * @return a list of pairs <The employee EID , The Employees name>
	 */
	@SuppressWarnings("unchecked")
	public List<NubemetEmployee> getWorksForMe(Long userEid){
		Session hybssn = HibernateUtils.getSessionFactory().getCurrentSession();
		if (hybssn == null)
			throw new WebServiceException("No session in WebServiceContext");
		hybssn.beginTransaction();
		
		List<NubemetEmployee> ret = new LinkedList<NubemetEmployee>();
		Iterator<Employee> itr = (hybssn.createQuery("SELECT emp from Employee as emp where bossID = :userEid").setParameter("userEid",userEid)).iterate();
		while (itr.hasNext()){
			NubemetEmployee nbe = new NubemetEmployee();
			Employee emp = itr.next();
			nbe.setName(emp.getUserName());
			nbe.setEid(emp.getEid());
			ret.add(nbe);
		}
			
		hybssn.getTransaction().commit();
		return ret;	
	}
	
	/**
	 * Removes a task from the DB.
	 * @param tid The task to remove id.
	 * @return true upon success , false else.
	 */
	public boolean removeTask (Long tid, Long userEid){
		Session hybssn = HibernateUtils.getSessionFactory().getCurrentSession();
		hybssn.beginTransaction();
		
		Tasks task2remove = (Tasks)hybssn.load(Tasks.class, tid);
		hybssn.delete(task2remove);
		
		hybssn.getTransaction().commit();
		return true;
	}
	
	/**
	 * Delegates a given task ID to the list of employees selected.
	 * @param delegateTo List of employees.
	 * @param tid The task ID to delegate.
	 * @return true upon success , false else.
	 */
	public boolean delegateTask(List<Long> delegateTo, Long tid, Long userEid){
		Session hybssn = HibernateUtils.getSessionFactory().getCurrentSession();
		hybssn.beginTransaction();
		
		Tasks task2Delegate = (Tasks)hybssn.load(Tasks.class, tid);
		for (Long delg2: delegateTo){
			DoneBy doneBy = new DoneBy();
			Employee emp = (Employee)hybssn.load(Employee.class, delg2);
			
			doneBy.setEmployee(emp);
			doneBy.setTask(task2Delegate);
		}
		
		hybssn.getTransaction().commit();
		return true;
	}
}
