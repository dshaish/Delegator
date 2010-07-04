package org.domain.delegator.session;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import org.domain.delegator.session.markedTasks;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

@Stateful
@Scope(ScopeType.SESSION)
@Name("MarkedTasks")
public class markedTasksBean implements markedTasks {

	// The list of marked tasks
	public List<Integer> markedList = new ArrayList<Integer>();
	public String lastMarked = ""; // Gets the value from the JS function

	public markedTasksBean() {
	}

	// *** Setter And Getters for "lastMarked": ***
	public String getLastMarked() {
		return lastMarked;
}

	public void setLastMarked(String lastMarked) {
		this.lastMarked = lastMarked;
		addToMarkedList(lastMarked); // Updates the list of marked files.
	}
	
	// Marks the task or removes the mark if marked before
	private void addToMarkedList(String lastMarked){
		if (markedList.contains(Integer.valueOf(lastMarked))) {
			markedList.remove(Integer.valueOf(lastMarked));
		} else {
			markedList.add(Integer.valueOf(lastMarked));
		}
	}
	
	// *** Setter And Getters for "markedList": ***
	public List<Integer> getMarkedList() {
		return markedList;
	}

	public void setMarkedList(List<Integer> markedList) {
		 this.markedList = markedList;
	}

	public void clearMarkedList() {
		markedList.clear();
	}

	@Remove
	public void remove() {
	}

	@Destroy
	public void destroy() {
	}
	
}
