package org.delegator.engine;

import org.delegator.entities.Tasks;

class TasksList {
	
	private static final String EJBQL = "select tasks from Tasks tasks";

	private static final String[] RESTRICTIONS = {
			"lower(tasks.title) like concat(lower(#{tasksList.tasks.title}),'%')",
			"lower(tasks.description) like concat(lower(#{tasksList.tasks.description}),'%')",
			"lower(tasks.attachment) like concat(lower(#{tasksList.tasks.attachment}),'%')",
			"lower(tasks.status) like concat(lower(#{tasksList.tasks.status}),'%')", };

	private Tasks tasks = new Tasks();

	public TasksList() {
	}

	public Tasks getTasks() {
		return tasks;
	}
	
	
	
}
