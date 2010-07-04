package org.domain.delegator.session;

import org.domain.delegator.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("updatesHome")
public class UpdatesHome extends EntityHome<Updates> {

	@In(create = true)
	TasksHome tasksHome;

	public void setUpdatesTid(Integer id) {
		setId(id);
	}

	public Integer getUpdatesTid() {
		return (Integer) getId();
	}

	@Override
	protected Updates createInstance() {
		Updates updates = new Updates();
		return updates;
	}

	public void wire() {
		getInstance();
		Tasks tasks = tasksHome.getDefinedInstance();
		if (tasks != null) {
			getInstance().setTasks(tasks);
		}
	}

	public boolean isWired() {
		if (getInstance().getTasks() == null)
			return false;
		return true;
	}

	public Updates getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
