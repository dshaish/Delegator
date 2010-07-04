package org.domain.delegator.session;

import org.domain.delegator.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("DelegatedTasksHome")
public class DelegatedTasksHome extends EntityHome<Tasks> {

	@In(create = true)
	UpdatesHome updatesHome;

	public void setTasksTid(Integer id) {
		setId(id);
	}

	public Integer getTasksTid() {
		return (Integer) getId();
	}

	@Override
	protected Tasks createInstance() {
		Tasks tasks = new Tasks();
		return tasks;
	}

	public void wire() {
		getInstance();
		Updates updates = updatesHome.getDefinedInstance();
		if (updates != null) {
			getInstance().setUpdates(updates);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Tasks getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<DoneBy> getDoneBies() {
		return getInstance() == null ? null : new ArrayList<DoneBy>(
				getInstance().getDoneBies());
	}

//	public List<TasksC> getTasksCsForParent() {
//		return getInstance() == null ? null : new ArrayList<TasksC>(
//				getInstance().getTasksCsForParent());
//	}
//
//	public List<TasksC> getTasksCsForTid() {
//		return getInstance() == null ? null : new ArrayList<TasksC>(
//				getInstance().getTasksCsForTid());
//	}

}
