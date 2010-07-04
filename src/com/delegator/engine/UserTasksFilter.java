/**
 * 
 */
package org.domain.delegator.session;

/**
 * @author tomerweller
 * 
 */
public enum UserTasksFilter {

	ACTIVE {
		@Override
		public String getQueryString(String currentFilter) {
			return "SELECT tasks from Tasks as tasks ,DoneBy as doneBy WHERE tasks.tid = doneBy.id.tid and doneBy.id.eid = #{loggedUser._UserEid} and tasks.status = 'Active'";
		}
	}, 
	ALL {
		@Override
		public String getQueryString(String currentFilter) {
			return "SELECT tasks from Tasks as tasks ,DoneBy as doneBy WHERE tasks.tid = doneBy.id.tid and doneBy.id.eid = #{loggedUser._UserEid}";
		}
	}, 
	FLAGGED {
		@Override
		public String getQueryString(String currentFilter) {
			return "SELECT tasks from Tasks as tasks ,DoneBy as doneBy WHERE tasks.tid = doneBy.id.tid and doneBy.id.eid = #{loggedUser._UserEid} and tasks.flagged = 1";		
		}
	}, 
	SUSPENDED {
		@Override
		public String getQueryString(String currentFilter) {
			return "SELECT tasks from Tasks as tasks ,DoneBy as doneBy WHERE tasks.tid = doneBy.id.tid and doneBy.id.eid = #{loggedUser._UserEid} and tasks.status = 'Suspended'";		
		}
	};
	public abstract String getQueryString(String currentFilter);
}

