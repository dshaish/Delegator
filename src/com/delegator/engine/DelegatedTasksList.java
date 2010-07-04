package org.domain.delegator.session;

import org.domain.delegator.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;

@Name("delegatedTasksList")
public class DelegatedTasksList extends EntityQuery<Tasks> {
	
	@In
	private EntityManager entityManager;
	
	private static final String EJBQL = "";

	private static final String[] RESTRICTIONS = {
			"lower(tasks.title) like concat(lower(#{tasksList.tasks.title}),'%')",
			"lower(tasks.description) like concat(lower(#{tasksList.tasks.description}),'%')",
			"lower(tasks.attachment) like concat(lower(#{tasksList.tasks.attachment}),'%')",
			"lower(tasks.status) like concat(lower(#{tasksList.tasks.status}),'%')", };

	private Tasks tasks = new Tasks();
	
	@SuppressWarnings("unchecked")
	public List<Tasks> resultList(String taskTid){
		List<Tasks> delegatedTasks;
		delegatedTasks = entityManager.createQuery(
				"SELECT tasks from Tasks tasks, TasksC tc WHERE tasks.tid = tc.tid AND tc.tasksByParentTaskId.tid <> tc.tid AND"
						+ " tc.tasksByParentTaskId.tid = :tasknum").setParameter("tasknum", Integer.valueOf(taskTid)).getResultList();
		return delegatedTasks;
	}
	
	
	public DelegatedTasksList() {
		
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Tasks getTasks() {
		return tasks;
	}
}
