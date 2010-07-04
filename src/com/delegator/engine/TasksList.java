package org.domain.delegator.session;

import org.domain.delegator.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("tasksList")
public class TasksList extends EntityQuery<Tasks> {

	private static final String EJBQL = "select tasks from Tasks tasks";

	private static final String[] RESTRICTIONS = {
			"lower(tasks.title) like concat(lower(#{tasksList.tasks.title}),'%')",
			"lower(tasks.description) like concat(lower(#{tasksList.tasks.description}),'%')",
			"lower(tasks.attachment) like concat(lower(#{tasksList.tasks.attachment}),'%')",
			"lower(tasks.status) like concat(lower(#{tasksList.tasks.status}),'%')", };

	private Tasks tasks = new Tasks();

	public TasksList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Tasks getTasks() {
		return tasks;
	}
}
