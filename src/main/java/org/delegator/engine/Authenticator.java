package org.delegator.engine;

public class Authenticator {

	/**
	 * Authenticate the logging user with the system. 
	 * @param userName The user name.
	 * @param password The password.
	 * @return true upon success , false else.
	 */
	public Long authenticate(String userName , String password){
		LoggedUserBean loggedUser = new LoggedUserBean();
		Long ueid = loggedUser.isRegistered(userName , password);
		return ueid;
	}
}

