package org.delegator.engine;

public class Authenticator {

	/**
	 * Authenticate the logging user with the system. 
	 * @param userName The user name.
	 * @param password The password.
	 * @return true upon success , false else.
	 */
	public int authenticate(String userName , String password){
		LoggedUserBean loggedUser = new LoggedUserBean();
		int ueid = loggedUser.isRegistered(userName , password);
		return ueid;
	}
}

