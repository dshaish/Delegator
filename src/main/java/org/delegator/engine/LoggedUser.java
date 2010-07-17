package org.delegator.engine;

public interface LoggedUser {

	public Long get_UserEid();
	public void set_UserEid(Long userEid);
	public Long isRegistered(String username, String password);

}
