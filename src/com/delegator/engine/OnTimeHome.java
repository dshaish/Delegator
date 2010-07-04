package org.domain.delegator.session;

import org.domain.delegator.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("onTimeHome")
public class OnTimeHome extends EntityHome<OnTime> {

	@In(create = true)
	EmployeeHome employeeHome;

	public void setOnTimeEid(Integer id) {
		setId(id);
	}

	public Integer getOnTimeEid() {
		return (Integer) getId();
	}

	@Override
	protected OnTime createInstance() {
		OnTime onTime = new OnTime();
		return onTime;
	}

	public void wire() {
		getInstance();
		Employee employee = employeeHome.getDefinedInstance();
		if (employee != null) {
			getInstance().setEmployee(employee);
		}
	}

	public boolean isWired() {
		if (getInstance().getEmployee() == null)
			return false;
		return true;
	}

	public OnTime getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
