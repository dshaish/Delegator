package org.delegator.engine;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.MessageContext;

public class Authenticator {

	@Resource
	private WebServiceContext wsContext;
	
	public boolean authenticate(String userName , String password){
		LoggedUserBean loggedUser = new LoggedUserBean();
		MessageContext mc = wsContext. getMessageContext();
		HttpSession session = ((javax.servlet.http.HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST)).getSession();
		if (session == null)
			throw new WebServiceException("No session in WebServiceContext");
		int ueid = loggedUser.isRegistered(userName , password);
		if ( ueid != -1) {
			session.setAttribute("userName", userName);
			session.setAttribute("userEid", ueid);
			return true;
		} else {
			return false;
		}
	}
}

