package org.delegator.engine;

import java.util.List;
import javax.jws.WebService;

import org.delegator.api.NubemetEmployee;
import org.delegator.api.NubemetTask;
import org.delegator.api.NubemetWebService;

@WebService(endpointInterface = "org.delegator.api.NubemetWebService")
public class NubemetWebServiceImpl implements NubemetWebService {
	
	TasksList tasksList = new TasksList();
	
	@Override
	public boolean addTask(NubemetTask newNubemetTask, Long userEid) {
		return tasksList.addTask(newNubemetTask, userEid);
	}

	@Override
	public boolean delegateTask(List<Long> delegateTo, Long tid, Long userEid) {
		return tasksList.delegateTask(delegateTo, tid, userEid);
	}

	@Override
	public List<NubemetTask> getTasks(Long userEid) {
		return tasksList.getTasks(userEid);
	}

	@Override
	public List<NubemetEmployee> getWorksForMe(Long userEid) {
		return tasksList.getWorksForMe(userEid);
	}

	@Override
	public boolean removeTask(Long tid, Long userEid) {
		return tasksList.removeTask(tid, userEid);
	}

	@Override
	public Long authenticate(String userName, String password) {
		Authenticator auth = new Authenticator();
		return auth.authenticate(userName, password);
	}
}
