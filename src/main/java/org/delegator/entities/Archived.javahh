package org.delegator.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "archived", catalog = "delegator")
@SuppressWarnings("unchecked")
public class Archived implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private int tid;
	private Archived archivedByParentTaskId;
	private Archived archivedByRootTaskId;
	private Employee employee;
	private Date cdate;
	private Date edate;
	private String title;
	private String description;
	private String attachment;
	private String status;
	private Integer parallel;
	
	private Set archivedsForRootTaskId = new HashSet(0);
	private Set archivedsForParentTaskId = new HashSet(0);
	private Set archivedsForRootTaskId_1 = new HashSet(0);
	private Set employees = new HashSet(0);
	private Set archivedsForParentTaskId_1 = new HashSet(0);
	private Set employees_1 = new HashSet(0);

	public Archived() {
	}

	public Archived(int tid, Archived archivedByParentTaskId,
			Archived archivedByRootTaskId, Employee employee, Date cdate,
			Date edate, String title, String status) {
		this.tid = tid;
		this.archivedByParentTaskId = archivedByParentTaskId;
		this.archivedByRootTaskId = archivedByRootTaskId;
		this.employee = employee;
		this.cdate = cdate;
		this.edate = edate;
		this.title = title;
		this.status = status;
	}

	public Archived(int tid, Archived archivedByParentTaskId,
			Archived archivedByRootTaskId, Employee employee, Date cdate,
			Date edate, String title, String description, String attachment,
			String status, Integer parallel, Set archivedsForRootTaskId,
			Set archivedsForParentTaskId, Set archivedsForRootTaskId_1,
			Set employees, Set archivedsForParentTaskId_1, Set employees_1) {
		this.tid = tid;
		this.archivedByParentTaskId = archivedByParentTaskId;
		this.archivedByRootTaskId = archivedByRootTaskId;
		this.employee = employee;
		this.cdate = cdate;
		this.edate = edate;
		this.title = title;
		this.description = description;
		this.attachment = attachment;
		this.status = status;
		this.parallel = parallel;
		this.archivedsForRootTaskId = archivedsForRootTaskId;
		this.archivedsForParentTaskId = archivedsForParentTaskId;
		this.archivedsForRootTaskId_1 = archivedsForRootTaskId_1;
		this.employees = employees;
		this.archivedsForParentTaskId_1 = archivedsForParentTaskId_1;
		this.employees_1 = employees_1;
	}

	@Id
	@Column(name = "Tid", unique = true, nullable = false)
	public int getTid() {
		return this.tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ParentTaskId", nullable = false)
	public Archived getArchivedByParentTaskId() {
		return this.archivedByParentTaskId;
	}

	public void setArchivedByParentTaskId(Archived archivedByParentTaskId) {
		this.archivedByParentTaskId = archivedByParentTaskId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rootTaskId", nullable = false)
	public Archived getArchivedByRootTaskId() {
		return this.archivedByRootTaskId;
	}

	public void setArchivedByRootTaskId(Archived archivedByRootTaskId) {
		this.archivedByRootTaskId = archivedByRootTaskId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CreatorId", nullable = false)
	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CDate", nullable = false, length = 19)
	public Date getCdate() {
		return this.cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EDate", nullable = false, length = 19)
	public Date getEdate() {
		return this.edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	@Column(name = "Title", nullable = false)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "Description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "Attachment")
	public String getAttachment() {
		return this.attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	@Column(name = "status", nullable = false, length = 15)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "parallel")
	public Integer getParallel() {
		return this.parallel;
	}

	public void setParallel(Integer parallel) {
		this.parallel = parallel;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "archivedByRootTaskId")
	public Set getArchivedsForRootTaskId() {
		return this.archivedsForRootTaskId;
	}

	public void setArchivedsForRootTaskId(Set archivedsForRootTaskId) {
		this.archivedsForRootTaskId = archivedsForRootTaskId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "archivedByParentTaskId")
	public Set getArchivedsForParentTaskId() {
		return this.archivedsForParentTaskId;
	}

	public void setArchivedsForParentTaskId(Set archivedsForParentTaskId) {
		this.archivedsForParentTaskId = archivedsForParentTaskId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "archivedByRootTaskId")
	public Set getArchivedsForRootTaskId_1() {
		return this.archivedsForRootTaskId_1;
	}

	public void setArchivedsForRootTaskId_1(Set archivedsForRootTaskId_1) {
		this.archivedsForRootTaskId_1 = archivedsForRootTaskId_1;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "archived_doneby", catalog = "delegator", joinColumns = { @JoinColumn(name = "Tid", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "Eid", nullable = false, updatable = false) })
	public Set getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set employees) {
		this.employees = employees;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "archivedByParentTaskId")
	public Set getArchivedsForParentTaskId_1() {
		return this.archivedsForParentTaskId_1;
	}

	public void setArchivedsForParentTaskId_1(Set archivedsForParentTaskId_1) {
		this.archivedsForParentTaskId_1 = archivedsForParentTaskId_1;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "archived_doneby", catalog = "delegator", joinColumns = { @JoinColumn(name = "Tid", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "Eid", nullable = false, updatable = false) })
	public Set getEmployees_1() {
		return this.employees_1;
	}

	public void setEmployees_1(Set employees_1) {
		this.employees_1 = employees_1;
	}

}
