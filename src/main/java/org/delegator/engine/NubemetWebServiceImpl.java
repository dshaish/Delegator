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
	public boolean addTask(NubemetTask newNubemetTask, int userEid) {
		return tasksList.addTask(newNubemetTask, userEid);
	}

	@Override
	public boolean delegateTask(List<Integer> delegateTo, int tid, int userEid) {
		return tasksList.delegateTask(delegateTo, tid, userEid);
	}

	@Override
	public List<NubemetTask> getTasks(UserTasksFilter filter, int userEid) {
		return tasksList.getTasks(filter, userEid);
	}

	@Override
	public HashMap<Integer, String> getWorksForMe(int userEid) {
		return tasksList.getWorksForMe(userEid);
	}

	@Override
	public boolean removeTask(int tid, int userEid) {
		return tasksList.removeTask(tid, userEid);
	}

	@Override
	public int authenticate(String userName, String password) {
		Authenticator auth = new Authenticator();
		return auth.authenticate(userName, password);
	}
}
