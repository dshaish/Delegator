package org.delegator.api;

import java.util.List;

public class NubemetWorksForList {
	
	/**
	 * A list of Eid that the user who sent this structure works for.
	 */
	List<Integer> worksForList;

	public List<Integer> getWorksForList() {
		return worksForList;
	}

	public void setWorksForList(List<Integer> worksForList) {
		this.worksForList = worksForList;
	}
}
