/**
 * 
 */
package org.delegator.engine;


public enum UserTasksFilter {
	ACTIVE , ALL , FLAGGED , SUSPENDED; 


	public static String getFilter(UserTasksFilter filter){
		switch(filter){
		case ACTIVE:
			return "SELECT tasks from Tasks as tasks ,DoneBy as doneBy WHERE tasks.tid = doneBy.id.tid and doneBy.id.eid = :userEid and tasks.status = 'Active'";
		case ALL:
			return "SELECT tasks from Tasks as tasks ,DoneBy as doneBy WHERE tasks.tid = doneBy.id.tid and doneBy.id.eid = :userEid";
		case FLAGGED:
			return "SELECT tasks from Tasks as tasks ,DoneBy as doneBy WHERE tasks.tid = doneBy.id.tid and doneBy.id.eid = :userEid and tasks.flagged = 1";		
		case SUSPENDED:
			return "SELECT tasks from Tasks as tasks ,DoneBy as doneBy WHERE tasks.tid = doneBy.id.tid and doneBy.id.eid = :userEid and tasks.status = 'Suspended'";		
		default :
			return null;
		}
	}
}
