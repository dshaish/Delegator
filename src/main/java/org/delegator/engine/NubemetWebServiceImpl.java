package org.delegator.engine;

import java.util.HashMap;
import java.util.List;

import javax.jws.WebService;
import org.delegator.api.NubemetTask;
import org.delegator.api.NubemetWebService;

@WebService(endpointInterface = "org.delegator.api.NubemetWebService")
public class NubemetWebServiceImpl implements NubemetWebService {
	
	TasksList tasksList = new TasksList();
	
	@Override
	public boolean addTask(NubemetTask newNubemetTask) {
		return tasksList.addTask(newNubemetTask);
	}

	@Override
	public boolean delegateTask(List<Integer> delegateTo, int tid) {
		return tasksList.delegateTask(delegateTo, tid);
	}

	@Override
	public List<NubemetTask> getTasks(UserTasksFilter filter) {
		return tasksList.getTasks(filter);
	}

	@Override
	public HashMap<Integer, String> getWorksForMe() {
		return tasksList.getWorksForMe();
	}

	@Override
	public boolean removeTask(int tid) {
		return tasksList.removeTask(tid);
	}

	@Override
	public boolean authenticate(String userName, String password) {
		Authenticator auth = new Authenticator();
		return auth.authenticate(userName, password);
	}
}
