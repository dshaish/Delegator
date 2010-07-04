package org.domain.delegator.session;

import org.domain.delegator.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("tasksCHome")
public class TasksCHome extends EntityHome<TasksC> {

	@In(create = true)
	TasksHome tasksHome;

	public void setTasksCTid(Integer id) {
		setId(id);
	}

	public Integer getTasksCTid() {
		return (Integer) getId();
	}

	@Override
	protected TasksC createInstance() {
		TasksC tasksC = new TasksC();
		return tasksC;
	}

	public void wire() {
		getInstance();
		Tasks tasksByTid = tasksHome.getDefinedInstance();
		if (tasksByTid != null) {
			getInstance().setTasksByTid(tasksByTid);
		}
		Tasks tasksByParentTaskId = tasksHome.getDefinedInstance();
		if (tasksByParentTaskId != null) {
			getInstance().setTasksByParentTaskId(tasksByParentTaskId);
		}
		Tasks tasksByRootTaskId = tasksHome.getDefinedInstance();
		if (tasksByRootTaskId != null) {
			getInstance().setTasksByRootTaskId(tasksByRootTaskId);
		}
	}

	public boolean isWired() {
		if (getInstance().getTasksByTid() == null)
			return false;
		if (getInstance().getTasksByParentTaskId() == null)
			return false;
		if (getInstance().getTasksByRootTaskId() == null)
			return false;
		return true;
	}

	public TasksC getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
