package org.domain.delegator.session;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.framework.EntityQuery;

import org.domain.delegator.entity.Employee;
import org.domain.delegator.session.LoggedUser;

@Stateful
@Scope(ScopeType.SESSION)
@Name("loggedUser")
public class LoggedUserBean extends EntityQuery<Employee> implements LoggedUser {

	private int _UserEid;
	private Employee emp;

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public LoggedUserBean() {
	}
	
	
	EntityManager entityManager = getEntityManager();

	public int get_UserEid() {
		return _UserEid;
	}

	public void set_UserEid(int userEid) {
		_UserEid = userEid;
	}

	public boolean isRegistered(String username, String password) {
		try {
			emp = (Employee) entityManager
					.createQuery(
							"from Employee where username = :username and password = :password")
					.setParameter("username", username).setParameter(
							"password", Integer.valueOf(password))
					.getSingleResult();
			if (emp != null) {
				_UserEid = emp.getEid();
				return true;
			}

		} catch (NoResultException ex) {
			return false;
		}
		return false;
	}
	
	@Remove
	public void remove() {
	}
	
	@Destroy
	public void destroy() {
	}
	
	
}
