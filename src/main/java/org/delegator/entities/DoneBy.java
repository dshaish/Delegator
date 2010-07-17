package org.delegator.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
//@Table(name = "employee", catalog = "dtemp")
@Table(name = "done_By")
public class DoneBy implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private Tasks task;
	private Employee employee;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="Tid",insertable=false,updatable=false)
	public Tasks getTask() {
		return task;
	}

	public void setTask(Tasks task) {
		this.task = task;
	}

	@ManyToOne
	@JoinColumn(name="Eid",insertable=false,updatable=false)
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
