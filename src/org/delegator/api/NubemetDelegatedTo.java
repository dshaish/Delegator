package org.delegator.api;

import java.util.List;

public class NubemetDelegatedTo {
	
	/**
	 * A list of employee id's who are given this task.
	 */
	private List<Integer> Eids;
	
	/**
	 * The task ID
	 */
	private Integer taskID;
	
	/**
	 * Was the task changed.
	 */
	private byte changed;
	
	public List<Integer> getEids() {
		return Eids;
	}
	public void setEids(List<Integer> eids) {
		Eids = eids;
	}
	public Integer getTaskID() {
		return taskID;
	}
	public void setTaskID(Integer taskID) {
		this.taskID = taskID;
	}
	public byte getChanged() {
		return changed;
	}
	public void setChanged(byte changed) {
		this.changed = changed;
	}
	
}
