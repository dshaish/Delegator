package src.com.delegator.entities;

// Generated 09:11:28 04/07/2010 by Hibernate Tools 3.3.0.GA

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * DoneBy generated by hbm2java
 */
@Entity
@Table(name = "done_by", catalog = "delegator")
public class DoneBy implements java.io.Serializable {

	private DoneById id;
	private Tasks tasks;
	private Employee employee;
	private byte changed;

	public DoneBy() {
	}

	public DoneBy(DoneById id, Tasks tasks, Employee employee, byte changed) {
		this.id = id;
		this.tasks = tasks;
		this.employee = employee;
		this.changed = changed;
	}

	@EmbeddedId
	@AttributeOverrides( {
			@AttributeOverride(name = "tid", column = @Column(name = "Tid", nullable = false)),
			@AttributeOverride(name = "eid", column = @Column(name = "Eid", nullable = false)) })
	public DoneById getId() {
		return this.id;
	}

	public void setId(DoneById id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Tid", nullable = false, insertable = false, updatable = false)
	public Tasks getTasks() {
		return this.tasks;
	}

	public void setTasks(Tasks tasks) {
		this.tasks = tasks;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Eid", nullable = false, insertable = false, updatable = false)
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Column(name = "Changed", nullable = false)
	public byte getChanged() {
		return this.changed;
	}

	public void setChanged(byte changed) {
		this.changed = changed;
	}

}
