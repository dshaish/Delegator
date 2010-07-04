package org.delegator.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "late", catalog = "delegator")
public class Late implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int eid;
	private Employee employee;
	private int counter;

	public Late() {
	}

	public Late(Employee employee, int counter) {
		this.employee = employee;
		this.counter = counter;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "employee"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "Eid", unique = true, nullable = false)
	public int getEid() {
		return this.eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Column(name = "Counter", nullable = false)
	public int getCounter() {
		return this.counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

}
