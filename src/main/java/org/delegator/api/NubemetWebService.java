package org.delegator.api;

import java.util.HashMap;
import java.util.List;
import javax.jws.WebService;

import org.delegator.engine.UserTasksFilter;

@WebService
public interface NubemetWebService {
	
	/**
	 * Returns the tasks list according to the connected user and the filter type.
	 * @param filter filter type for the list extraction from the DB.
	 * @return the list of tasks for the user.
	 */
	public List<NubemetTask> getTasks(UserTasksFilter filter, int userEid);
	
	/**
	 * Adds a new task to the user's list.
	 * The delegation process is not done here!.
	 * @param newNubemetTask The new Task	 
	 * @return true on success, false else.
	 */
	public boolean addTask(NubemetTask newNubemetTask, int userEid);
	
	/**
	 * Returns a list of people who works for me.
	 * @return a list of pairs <The employee EID , The Employees name>
	 */
	public HashMap<Integer, String> getWorksForMe(int userEid);
	
	/**
	 * Removes a task from the DB.
	 * @param tid The task to remove id.
	 * @return true upon success , false else.
	 */
	public boolean removeTask (int tid, int userEid);
	
	/**
	 * Delegates a given task ID to the list of employees selected.
	 * @param delegateTo List of employees.
	 * @param tid The task ID to delegate.
	 * @return true upon success , false else.
	 */
	public boolean delegateTask(List<Integer> delegateTo, int tid, int userEid);
	
	/**
	 * Authenticate the logging user with the system. 
	 * @param userName The user name.
	 * @param password The password.
	 * @return true upon success , false else.
	 */
	public int authenticate(String userName , String password);
}
