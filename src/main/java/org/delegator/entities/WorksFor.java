package org.delegator.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "works_for", catalog = "dtemp")
public class WorksFor implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Employee manager;
	private Employee employee;
	
	
	
	public WorksFor() {
	}
	public Employee getManager() {
		return manager;
	}
	public void setManager(Employee manager) {
		this.manager = manager;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
}
