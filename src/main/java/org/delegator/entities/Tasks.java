package org.delegator.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
//@Table(name = "tasks", catalog = "dtemp")
@Table(name = "tasks")
public class Tasks implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long tid;
	private Date cDate;
	private Date eDate;
	private String title;
	private String description;
	private byte delegated;
	private Employee creator;
	private List<DoneBy> doneBy;
	

	public Tasks() {
		
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Tid", nullable = false)
	public Long getTid() {
		return tid;
	}


	public void setTid(Long tid) {
		this.tid = tid;
	}

	@Column(name = "CDate", nullable = false)
	public Date getcDate() {
		return cDate;
	}


	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}

	@Column(name = "EDate", nullable = true)
	public Date geteDate() {
		return eDate;
	}


	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}

	@Column(name = "Title", nullable = false)
	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "Description", nullable = true)
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "Delegated", nullable = false)
	public byte getDelegated() {
		return delegated;
	}


	public void setDelegated(byte delegated) {
		this.delegated = delegated;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="CreatorId")
	public Employee getCreator() {
		return creator;
	}


	public void setCreator(Employee creator) {
		this.creator = creator;
	}

	@OneToMany( cascade = CascadeType.ALL )
	//@org.hibernate.annotations.OnDelete(action=OnDeleteAction.CASCADE)
	@JoinColumn(name="tid")
	public List<DoneBy> getDoneBy() {
		return doneBy;
	}


	public void setDoneBy(List<DoneBy> doneBy) {
		this.doneBy = doneBy;
	}


	
	

}
