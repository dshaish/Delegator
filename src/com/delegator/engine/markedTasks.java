package org.domain.delegator.session;


import java.util.List;
import javax.ejb.Local;

@Local
public interface markedTasks {

	// *** Setter And Getters for "lastMarked": ***
	public String getLastMarked();
	// Marks the task or removes the mark if marked before
	public void setLastMarked(String lastMarked);
	
	// *** Setter And Getters for "markedList": ***
	public List<Integer> getMarkedList();
	public void setMarkedList(List<Integer> markedList);
	public void clearMarkedList();
	
	public void remove();
	public void destroy();
	
}