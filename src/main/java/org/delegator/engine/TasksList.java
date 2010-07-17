package org.delegator.engine;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.xml.ws.WebServiceException;
import org.delegator.api.NubemetTask;
import org.delegator.entities.DoneBy;
import org.delegator.entities.Employee;
import org.delegator.entities.Tasks;
import org.hibernate.Query;
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
		
		
		
		Tasks newTask = new Tasks();
		newTask.setTitle(newNubemetTask.getTitle());
		newTask.setDescription(newNubemetTask.getDescription());
		newTask.setTid(newNubemetTask.getTid());
		newTask.setcDate(newNubemetTask.getCdate());
		newTask.setCreator(emp);
		newTask.seteDate(newNubemetTask.getEdate());
		newTask.setDelegated(newNubemetTask.getDelegated());
		newTask.setDelegated(newNubemetTask.getDelegated());

		DoneBy doneBy = new DoneBy();
		doneBy.setEmployee(emp);
		List<DoneBy> doneByList = new LinkedList<DoneBy>();
		doneByList.add(doneBy);
		newTask.setDoneBy(doneByList);
		doneBy.setTask(newTask);
		
		hybssn.save(newTask);
		hybssn.getTransaction().commit();
		
		return true;
	}
	
	/**
	 * Returns a list of people who works for me.
	 * @return a list of pairs <The employee EID , The Employees name>
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getWorksForMe(Long userEid){
		Session hybssn = HibernateUtils.getSessionFactory().getCurrentSession();
		if (hybssn == null)
			throw new WebServiceException("No session in WebServiceContext");
		
		List<Employee> ret = new LinkedList<Employee>();
		Query itr = hybssn.createQuery("from employee where bossId = :userEid")
							.setParameter("userEid",userEid);
		ret = (List<Employee>)itr.list();					
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
		
		//Tasks task2remove = (Tasks)hybssn.load(Tasks.class, tid);
		//hybssn.delete(task2remove);
		
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
//		Session hybssn = HibernateUtils.getSessionFactory().getCurrentSession();
//		hybssn.beginTransaction();
//		
//		Tasks task2Delegate = (Tasks)hybssn.load(Tasks.class, tid);
//		for (Integer delg2: delegateTo){
//			DoneBy doneBy = new DoneBy();
//			Employee emp = (Employee)hybssn.load(Employee.class, delg2);
//			DoneById doneById = new DoneById();
//			
//			doneById.setEid(emp.getEid());
//			doneById.setTid(tid);
//			doneBy.setEmployee(emp);
//			doneBy.setTasks(task2Delegate);
//			doneBy.setId(doneById);
//			doneBy.setChanged((byte) 1);
//		}
//		
//		hybssn.getTransaction().commit();
//		
		return true;
	}
}
