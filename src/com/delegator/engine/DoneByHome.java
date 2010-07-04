package org.domain.delegator.session;

import org.domain.delegator.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("doneByHome")
public class DoneByHome extends EntityHome<DoneBy> {

	@In(create = true)
	TasksHome tasksHome;
	@In(create = true)
	EmployeeHome employeeHome;

	public void setDoneById(DoneById id) {
		setId(id);
	}

	public DoneById getDoneById() {
		return (DoneById) getId();
	}

	public DoneByHome() {
		setDoneById(new DoneById());
	}

	@Override
	public boolean isIdDefined() {
		if (getDoneById().getTid() == 0)
			return false;
		if (getDoneById().getEid() == 0)
			return false;
		return true;
	}

	@Override
	protected DoneBy createInstance() {
		DoneBy doneBy = new DoneBy();
		doneBy.setId(new DoneById());
		return doneBy;
	}

	public void wire() {
		getInstance();
		Tasks tasks = tasksHome.getDefinedInstance();
		if (tasks != null) {
			getInstance().setTasks(tasks);
		}
		Employee employee = employeeHome.getDefinedInstance();
		if (employee != null) {
			getInstance().setEmployee(employee);
		}
	}

	public boolean isWired() {
		if (getInstance().getTasks() == null)
			return false;
		if (getInstance().getEmployee() == null)
			return false;
		return true;
	}

	public DoneBy getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
