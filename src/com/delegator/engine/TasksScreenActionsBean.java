package org.domain.delegator.session;

import java.util.Iterator;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import org.domain.delegator.entity.Tasks;
import org.domain.delegator.session.TasksScreenActions;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.annotations.Scope;

@Stateful
@Scope(ScopeType.SESSION)
@Name("tasksActions")
public class TasksScreenActionsBean implements TasksScreenActions {

	@In(value = "MarkedTasks", create = true)
	@Out(value = "MarkedTasks")
	public markedTasks markedTasks;

	@In(create = false)
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	public EntityManager entityManager;

	public void suspendMarkedTasks() {
		Iterator<Integer> itr = markedTasks.getMarkedList().iterator();
		Tasks tmp;
		while (itr.hasNext()) {
			tmp = entityManager.find(Tasks.class, itr.next());
			tmp.setStatus("Suspended");
			entityManager.persist(tmp);
		}
		markedTasks.clearMarkedList();
	}
	
	public void ReActivateTasks() {
		Iterator<Integer> itr = markedTasks.getMarkedList().iterator();
		Tasks tmp;
		while (itr.hasNext()) {
			tmp = entityManager.find(Tasks.class, itr.next());
			tmp.setStatus("Active");
			entityManager.persist(tmp);
		}
		markedTasks.clearMarkedList();
	}
	
	public void clearMarkedList(){
		markedTasks.clearMarkedList();
	}
	public void markeAsReadMarked(){
		
	}
	
	public void markAsReadTasks(){
		Iterator<Integer> itr = markedTasks.getMarkedList().iterator();
		Tasks tmp;
		while (itr.hasNext()) {
			tmp = entityManager.find(Tasks.class, itr.next());
			tmp.getDoneBies().iterator().next().setChanged((byte) 0);
			entityManager.persist(tmp);
		}
		markedTasks.clearMarkedList();
	}
	
	public void markAsUnReadTasks(){
		Iterator<Integer> itr = markedTasks.getMarkedList().iterator();
		Tasks tmp;
		while (itr.hasNext()) {
			tmp = entityManager.find(Tasks.class, itr.next());
			tmp.getDoneBies().iterator().next().setChanged((byte) 1);
			entityManager.persist(tmp);
		}
		markedTasks.clearMarkedList();
	}
	
	@Remove
	public void remove() {
	}

	@Destroy
	public void destroy() {
	}

}
