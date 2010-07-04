package org.domain.delegator.session;

import org.domain.delegator.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.security.Restrict;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
@Name("viewUserTasks")
<<<<<<< .mine
@Restrict("#{identity.loggedIn}")
public class ViewUserTasks extends EntityQuery<Tasks> {
=======
//@Restrict("#{identity.loggedIn}")
public class ViewUserTasks extends EntityQuery<Tasks> {
>>>>>>> .r136
	
	private static final String[] RESTRICTIONS = {
			"lower(tasks.title) like concat(lower(#{tasksList.tasks.title}),'%')",
			"lower(tasks.description) like concat(lower(#{tasksList.tasks.description}),'%')",
			"lower(tasks.attachment) like concat(lower(#{tasksList.tasks.attachment}),'%')",
			"lower(tasks.status) like concat(lower(#{tasksList.tasks.status}),'%')", };

	private Tasks tasks = new Tasks();
	
	public String searchString;
	
	private String currentFilter;

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public ViewUserTasks() {
		switchFilter("ALL");
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}
	
	/**
	 * Use query matching the appropriate filter.
	 * @param filter a string matching a specific UserTasksFilter enum.
	 */
	public void switchFilter(String filter){
		currentFilter = filter;
		setEjbql(UserTasksFilter.valueOf(filter).getQueryString(currentFilter));
		//needs to refresh the view as well. 
	}
	public void searchTask(){
		setEjbql("SELECT tasks from Tasks as tasks ,DoneBy as doneBy WHERE (tasks.tid = doneBy.id.tid and doneBy.id.eid = #{loggedUser._UserEid}) and (tasks.title like '%"+searchString+"%' or tasks.description like '%"+searchString+"%')");	
	}
	
	public Tasks getTasks() {
		return tasks;
	}
	
}
