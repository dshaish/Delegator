package org.delegator.engine;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.MessageContext;
import org.delegator.api.NubemetTask;
import org.delegator.entities.DoneBy;
import org.delegator.entities.DoneById;
import org.delegator.entities.Employee;
import org.delegator.entities.Tasks;
import org.delegator.entities.TasksC;
import org.delegator.entities.WorksFor;
import org.hibernate.Session;

class TasksList{
	@Resource
	private WebServiceContext wsContext;
	
	public TasksList() {
	}

	/**
	 * Returns the tasks list according to the connected user and the filter type.
	 * @param filter filter type for the list extraction from the DB.
	 * @param userEid 
	 * @return the list of tasks for the user.
	 */
	public List<NubemetTask> getTasks(UserTasksFilter filter, int userEid) {
		// Initialize base parameters
		MessageContext mc = wsContext. getMessageContext();
		HttpSession session = ((javax.servlet.http.HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST)).getSession();
		Session hybssn = HibernateUtils.getSessionFactory().getCurrentSession();
		if (session == null || hybssn == null)
			throw new WebServiceException("No session in WebServiceContext");
		List<NubemetTask> tasksList = new LinkedList<NubemetTask>();
		// Run the query:
		Iterator<?> results= hybssn.createQuery(UserTasksFilter.getFilter(filter))
							.setParameter("userEid", session.getAttribute("userEid")).iterate();
		while(results.hasNext()) {
			// Convert from Tasks entity to NubemetTask.
			Tasks curTask = (Tasks)results.next();
			NubemetTask curNubemetTask = new NubemetTask();
			curNubemetTask.setTitle(curTask.getTitle());
			curNubemetTask.setDescription(curTask.getDescription());
			curNubemetTask.setTid(curTask.getTid());
			curNubemetTask.setStatus(curTask.getStatus());
			curNubemetTask.setCdate(curTask.getCdate());
			curNubemetTask.setEdate(curTask.getEdate());
			curNubemetTask.setFinishedDate(curTask.getFinishedDate());
			curNubemetTask.setAttachment(curTask.getAttachment());
			curNubemetTask.setFlagged(curTask.getFlagged());
			curNubemetTask.setDelegated(curTask.getDelegated());
			curNubemetTask.setDelegated(curTask.getDelegated());
			curNubemetTask.setUpdates(curTask.getUpdates());
			tasksList.add(curNubemetTask);
		}
		return tasksList;
	}
	
	/**
	 * Adds a new task to the user's list.
	 * The delegation process is not done here!.
	 * @param newNubemetTask The new Task	 
	 * @param userEid 
	 * @return true on success, false else.
	 */
	public boolean addTask(NubemetTask newNubemetTask, int userEid){
		MessageContext mc = wsContext. getMessageContext();
		HttpSession session = ((javax.servlet.http.HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST)).getSession();
		Session hybssn = HibernateUtils.getSessionFactory().getCurrentSession();
		if (session == null || hybssn == null)
			throw new WebServiceException("No session in WebServiceContext");
		
		Employee emp = (Employee)hybssn
							.createQuery("from Employee where Eid = :userEid")
							.setParameter("userEid", session.getAttribute("userEid"))
							.uniqueResult();
		
		hybssn.beginTransaction();
		Tasks newTask = new Tasks();
		newTask.setTitle(newNubemetTask.getTitle());
		newTask.setDescription(newNubemetTask.getDescription());
		newTask.setTid(newNubemetTask.getTid());
		newTask.setStatus(newNubemetTask.getStatus());
		newTask.setCdate(newNubemetTask.getCdate());
		newTask.setEdate(newNubemetTask.getEdate());
		newTask.setFinishedDate(newNubemetTask.getFinishedDate());
		newTask.setAttachment(newNubemetTask.getAttachment());
		newTask.setFlagged(newNubemetTask.getFlagged());
		newTask.setDelegated(newNubemetTask.getDelegated());
		newTask.setDelegated(newNubemetTask.getDelegated());
		newTask.setUpdates(newNubemetTask.getUpdates());
				
		DoneById doneById = new DoneById(newTask.getTid(), emp.getEid());
		DoneBy doneBy = new DoneBy(doneById, newTask, emp , (byte) 0);
		TasksC tasksC = new TasksC(newTask, newTask, newTask); 

		hybssn.save(doneBy);
		hybssn.save(tasksC);
		hybssn.save(newTask);
		
		hybssn.getTransaction().commit();
		
		return true;
	}
	
	/**
	 * Returns a list of people who works for me.
	 * @return a list of pairs <The employee EID , The Employees name>
	 */
	public HashMap<Integer, String> getWorksForMe(int userEid){
		MessageContext mc = wsContext. getMessageContext();
		HttpSession session = ((javax.servlet.http.HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST)).getSession();
		Session hybssn = HibernateUtils.getSessionFactory().getCurrentSession();
		if (session == null || hybssn == null)
			throw new WebServiceException("No session in WebServiceContext");
		
		HashMap<Integer, String> ret = new HashMap<Integer, String>();
		
		Iterator<?> itr = hybssn.createQuery("from works_for where ManagerId = :userEid")
							.setParameter("userEid", session.getAttribute("userEid"))
							.iterate();
		while (itr.hasNext()){
			itr.next();
			ret.put((((WorksFor)itr).getId()).getEid() , 
					((Employee)hybssn.load(Employee.class, (((WorksFor)itr).getId()).getEid())).getName());
		}
		
		return ret;	
	}
	
	/**
	 * Removes a task from the DB.
	 * @param tid The task to remove id.
	 * @return true upon success , false else.
	 */
	public boolean removeTask (int tid, int userEid){
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
	public boolean delegateTask(List<Integer> delegateTo, int tid, int userEid){
		Session hybssn = HibernateUtils.getSessionFactory().getCurrentSession();
		hybssn.beginTransaction();
		
		Tasks task2Delegate = (Tasks)hybssn.load(Tasks.class, tid);
		for (Integer delg2: delegateTo){
			DoneBy doneBy = new DoneBy();
			Employee emp = (Employee)hybssn.load(Employee.class, delg2);
			DoneById doneById = new DoneById();
			
			doneById.setEid(emp.getEid());
			doneById.setTid(tid);
			doneBy.setEmployee(emp);
			doneBy.setTasks(task2Delegate);
			doneBy.setId(doneById);
			doneBy.setChanged((byte) 1);
		}
		
		hybssn.getTransaction().commit();
		
		return true;
	}
}