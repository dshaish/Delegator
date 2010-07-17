package org.delegator.api;

import java.util.Date;
import java.util.List;
//import org.delegator.entities.Updates;

public class NubemetTask {
	
	private Long tid;
	private Date cdate;
	private Date edate;
	private String title;
	private String description;
	private byte delegated;
	private List<Integer> doneBy;
	
	public Long getTid() {
		return tid;
	}
	
	public void setTid(Long tid) {
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

}
