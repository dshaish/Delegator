package org.delegator.api;

import java.util.Date;
import java.util.List;
import org.delegator.entities.Updates;

public class NubemetTask {
	
	private Integer tid;
	private Date cdate;
	private Date edate;
	private Date finishedDate;
	private String title;
	private String description;
	private String attachment;
	private String status;
	private byte flagged;
	private byte delegated;
	private List<Integer> doneBy;
	private Updates updates;
	
	
	public Integer getTid() {
		return tid;
	}
	
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public Date getEdate() {
		return edate;
	}
	public void setEdate(Date edate) {
		this.edate = edate;
	}
	public Date getFinishedDate() {
		return finishedDate;
	}
	public void setFinishedDate(Date finishedDate) {
		this.finishedDate = finishedDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public byte getFlagged() {
		return flagged;
	}
	public void setFlagged(byte flagged) {
		this.flagged = flagged;
	}
	public byte getDelegated() {
		return delegated;
	}
	public void setDelegated(byte delegated) {
		this.delegated = delegated;
	}
	public List<Integer> getDoneBy() {
		return doneBy;
	}
	public void setDoneBy(List<Integer> doneBy) {
		this.doneBy = doneBy;
	}
	public Updates getUpdates() {
		return updates;
	}
	public void setUpdates(Updates updates) {
		this.updates = updates;
	}
}
