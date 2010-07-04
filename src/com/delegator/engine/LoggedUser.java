package org.domain.delegator.session;

import javax.ejb.Remote;

@Remote
public interface LoggedUser {

	public int get_UserEid();
	public void set_UserEid(int userEid);
	public boolean isRegistered(String username, String password);

}
