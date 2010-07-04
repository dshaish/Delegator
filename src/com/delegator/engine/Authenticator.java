package org.domain.delegator.session;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;

@Name("authenticator")
public class Authenticator {

	@Logger
	private Log log;

	@In
	Identity identity;
	@In
	Credentials credentials;
	
	@Out
	public LoggedUserBean loggedUser = new LoggedUserBean();
	
	public boolean authenticate() {
		// Log the login:
		log.info("authenticating {0}", credentials.getUsername());
		// Send The query parameters to the entity:
		if (loggedUser.isRegistered(credentials.getUsername(), credentials
				.getPassword())) {
			return true;
		} else {
			FacesMessages.instance().add("Invalid username/password/No Authentication!");
			return false;
		}
	}
}
