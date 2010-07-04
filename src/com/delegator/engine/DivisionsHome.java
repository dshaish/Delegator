package org.domain.delegator.session;

import org.domain.delegator.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("divisionsHome")
public class DivisionsHome extends EntityHome<Divisions> {

	@In(create = true)
	EmployeeHome employeeHome;

	public void setDivisionsDivId(Integer id) {
		setId(id);
	}

	public Integer getDivisionsDivId() {
		return (Integer) getId();
	}

	@Override
	protected Divisions createInstance() {
		Divisions divisions = new Divisions();
		return divisions;
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

	public Divisions getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
