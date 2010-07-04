package org.domain.delegator.session;

import javax.ejb.Local;

@Local
public interface TasksScreenActions {
	
	public void suspendMarkedTasks();
	public void markeAsReadMarked();
	public void ReActivateTasks();
	public void clearMarkedList();
	public void markAsReadTasks();
	public void markAsUnReadTasks();
	public void remove();
	public void destroy();

}
