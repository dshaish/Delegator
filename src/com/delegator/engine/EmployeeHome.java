package org.domain.delegator.session;

import org.domain.delegator.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("employeeHome")
public class EmployeeHome extends EntityHome<Employee> {

	@In(create = true)
	LateHome lateHome;
	@In(create = true)
	OnTimeHome onTimeHome;

	public void setEmployeeEid(Integer id) {
		setId(id);
	}

	public Integer getEmployeeEid() {
		return (Integer) getId();
	}

	@Override
	protected Employee createInstance() {
		Employee employee = new Employee();
		return employee;
	}

	public void wire() {
		getInstance();
		Late late = lateHome.getDefinedInstance();
		if (late != null) {
			getInstance().setLate(late);
		}
		OnTime onTime = onTimeHome.getDefinedInstance();
		if (onTime != null) {
			getInstance().setOnTime(onTime);
		}
	}

	public boolean isWired() {
		return true;
	}

	public Employee getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Tasks> getTaskses() {
		return getInstance() == null ? null : new ArrayList<Tasks>(
				getInstance().getTaskses());
	}

	public List<Archived> getArchiveds() {
		return getInstance() == null ? null : new ArrayList<Archived>(
				getInstance().getArchiveds());
	}

	public List<Divisions> getDivisionses_1() {
		return getInstance() == null ? null : new ArrayList<Divisions>(
				getInstance().getDivisionses_1());
	}

	public List<DoneBy> getDoneBies() {
		return getInstance() == null ? null : new ArrayList<DoneBy>(
				getInstance().getDoneBies());
	}

}
