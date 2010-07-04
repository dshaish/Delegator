package org.domain.delegator.session;

import org.domain.delegator.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("lateHome")
public class LateHome extends EntityHome<Late> {

	@In(create = true)
	EmployeeHome employeeHome;

	public void setLateEid(Integer id) {
		setId(id);
	}

	public Integer getLateEid() {
		return (Integer) getId();
	}

	@Override
	protected Late createInstance() {
		Late late = new Late();
		return late;
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

	public Late getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
