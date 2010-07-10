package org.delegator.engine;

public interface LoggedUser {

	public int get_UserEid();
	public void set_UserEid(int userEid);
	public int isRegistered(String username, String password);

}
