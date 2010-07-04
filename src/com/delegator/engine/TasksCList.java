package org.domain.delegator.session;

import org.domain.delegator.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("tasksCList")
public class TasksCList extends EntityQuery<TasksC> {

	private static final String EJBQL = "select tasksC from TasksC tasksC";

	private static final String[] RESTRICTIONS = {};

	private TasksC tasksC = new TasksC();

	public TasksCList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public TasksC getTasksC() {
		return tasksC;
	}
}
