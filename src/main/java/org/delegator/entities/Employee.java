package org.delegator.entities;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private Long eid;
	private String userName;
	private String name;
	private String lname;
	private Integer password;
	private List<DoneBy> doneBy;
	private Employee boss;
	private List<Employee> employee;
	
	public void addToDoneBy(DoneBy newDoneBy){
		if (doneBy == null){
			doneBy = new LinkedList<DoneBy>();
		}
		doneBy.add(newDoneBy);
	}
	
	@Id
	@Column(name = "Eid", nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getEid() {
		return eid;
	}
	public void setEid(Long eid) {
		this.eid = eid;
	}
	
	@Column(name = "UserName", nullable = false)
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "Name", nullable = false)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "LName", nullable = false)
	public String getLname() {
		return lname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	@Column(name = "Password", nullable = false)
	public Integer getPassword() {
		return password;
	}
	
	public void setPassword(Integer password) {
		this.password = password;
	}

	@OneToMany
    @JoinColumn(name="Eid")
	public List<DoneBy> getDoneBy() {
		return doneBy;
	}
	
	public void setDoneBy(List<DoneBy> doneBy) {
		this.doneBy = doneBy;
	}
	
	
	@ManyToOne(cascade={},fetch=FetchType.LAZY)
	@JoinColumn(name="bossId")
	public Employee getBoss() {
		return boss;
	}
	public void setBoss(Employee boss) {
		this.boss = boss;
	}
	
	@OneToMany(cascade={},fetch=FetchType.LAZY)
	@JoinColumn(name="bossId")
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	
	
}
