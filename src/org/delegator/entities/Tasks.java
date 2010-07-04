package org.delegator.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "tasks", catalog = "delegator")
@SuppressWarnings("unchecked")
public class Tasks implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer tid;
	private Employee employee;
	private Date cdate;
	private Date edate;
	private Date finishedDate;
	private String title;
	private String description;
	private String attachment;
	private String status;
	private byte flagged;
	private byte delegated;
	private Set tasksCsForParentTaskId = new HashSet(0);
	private Set tasksCsForRootTaskId = new HashSet(0);
	private Set doneBies = new HashSet(0);
	private Set doneBies_1 = new HashSet(0);
	private Set tasksCsForParentTaskId_1 = new HashSet(0);
	private TasksC tasksCByTid;
	private Updates updates;
	private Set tasksCsForRootTaskId_1 = new HashSet(0);

	public Tasks() {
	}

	public Tasks(Date cdate, String title, String status, byte flagged,
			byte delegated) {
		this.cdate = cdate;
		this.title = title;
		this.status = status;
		this.flagged = flagged;
		this.delegated = delegated;
	}

	public Tasks(Employee employee, Date cdate, Date edate, Date finishedDate,
			String title, String description, String attachment, String status,
			byte flagged, byte delegated, Set tasksCsForParentTaskId,
			Set tasksCsForRootTaskId, Set doneBies, Set doneBies_1,
			Set tasksCsForParentTaskId_1, TasksC tasksCByTid, Updates updates,
			Set tasksCsForRootTaskId_1) {
		this.employee = employee;
		this.cdate = cdate;
		this.edate = edate;
		this.finishedDate = finishedDate;
		this.title = title;
		this.description = description;
		this.attachment = attachment;
		this.status = status;
		this.flagged = flagged;
		this.delegated = delegated;
		this.tasksCsForParentTaskId = tasksCsForParentTaskId;
		this.tasksCsForRootTaskId = tasksCsForRootTaskId;
		this.doneBies = doneBies;
		this.doneBies_1 = doneBies_1;
		this.tasksCsForParentTaskId_1 = tasksCsForParentTaskId_1;
		this.tasksCByTid = tasksCByTid;
		this.updates = updates;
		this.tasksCsForRootTaskId_1 = tasksCsForRootTaskId_1;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Tid", unique = true, nullable = false)
	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CreatorId")
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
	@Column(name = "EDate", length = 19)
	public Date getEdate() {
		return this.edate;
	}

	public void setEdate(Date edate) {
		this.edate = edate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FinishedDate", length = 19)
	public Date getFinishedDate() {
		return this.finishedDate;
	}

	public void setFinishedDate(Date finishedDate) {
		this.finishedDate = finishedDate;
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

	@Column(name = "Status", nullable = false, length = 15)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "Flagged", nullable = false)
	public byte getFlagged() {
		return this.flagged;
	}

	public void setFlagged(byte flagged) {
		this.flagged = flagged;
	}

	@Column(name = "Delegated", nullable = false)
	public byte getDelegated() {
		return this.delegated;
	}

	public void setDelegated(byte delegated) {
		this.delegated = delegated;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tasksByParentTaskId")
	public Set getTasksCsForParentTaskId() {
		return this.tasksCsForParentTaskId;
	}

	public void setTasksCsForParentTaskId(Set tasksCsForParentTaskId) {
		this.tasksCsForParentTaskId = tasksCsForParentTaskId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tasksByRootTaskId")
	public Set getTasksCsForRootTaskId() {
		return this.tasksCsForRootTaskId;
	}

	public void setTasksCsForRootTaskId(Set tasksCsForRootTaskId) {
		this.tasksCsForRootTaskId = tasksCsForRootTaskId;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tasks")
	public Set getDoneBies() {
		return this.doneBies;
	}

	public void setDoneBies(Set doneBies) {
		this.doneBies = doneBies;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tasks")
	public Set getDoneBies_1() {
		return this.doneBies_1;
	}

	public void setDoneBies_1(Set doneBies_1) {
		this.doneBies_1 = doneBies_1;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tasksByParentTaskId")
	public Set getTasksCsForParentTaskId_1() {
		return this.tasksCsForParentTaskId_1;
	}

	public void setTasksCsForParentTaskId_1(Set tasksCsForParentTaskId_1) {
		this.tasksCsForParentTaskId_1 = tasksCsForParentTaskId_1;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "tasksByTid")
	public TasksC getTasksCByTid() {
		return this.tasksCByTid;
	}

	public void setTasksCByTid(TasksC tasksCByTid) {
		this.tasksCByTid = tasksCByTid;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "tasks")
	public Updates getUpdates() {
		return this.updates;
	}

	public void setUpdates(Updates updates) {
		this.updates = updates;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tasksByRootTaskId")
	public Set getTasksCsForRootTaskId_1() {
		return this.tasksCsForRootTaskId_1;
	}

	public void setTasksCsForRootTaskId_1(Set tasksCsForRootTaskId_1) {
		this.tasksCsForRootTaskId_1 = tasksCsForRootTaskId_1;
	}

}
