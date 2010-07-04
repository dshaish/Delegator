package org.domain.delegator.session;

import org.domain.delegator.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;
import java.util.List;

@Name("employeeList")
public class EmployeeList extends EntityQuery<Employee> {

	@In (create = false)
	LoggedUserBean loggedUser;	
	
	private static final String EJBQL = "select employee from Employee employee";

	private static final String[] RESTRICTIONS = {
			"lower(employee.userName) like concat(lower(#{employeeList.employee.userName}),'%')",
			"lower(employee.name) like concat(lower(#{employeeList.employee.name}),'%')",
			"lower(employee.jobDesc) like concat(lower(#{employeeList.employee.jobDesc}),'%')",
			"lower(employee.lname) like concat(lower(#{employeeList.employee.lname}),'%')",
			"lower(employee.address) like concat(lower(#{employeeList.employee.address}),'%')",
			"lower(employee.email) like concat(lower(#{employeeList.employee.email}),'%')",
			"lower(employee.auth) like concat(lower(#{employeeList.employee.auth}),'%')", };

	private Employee employee = new Employee();

	public EmployeeList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> getWorkers(){

		List<Employee> tmp = this.getEntityManager().createQuery(
				"select employee from Employee as employee,WorksFor as worksfor WHERE" +
				" employee.eid=worksfor.id.eid and worksfor.id.managerId = :myId").
				setParameter("myId", loggedUser.get_UserEid()).getResultList();
		
		return tmp;

	}

	public Employee getEmployee() {
		return employee;
	}
}
