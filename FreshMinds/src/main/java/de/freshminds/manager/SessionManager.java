package de.freshminds.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionManager {
	
	public void setString(HttpServletRequest request, String messageType, String message) {
		HttpSession session= request.getSession();
    	session.setAttribute(messageType, message);
	}
	
	public String getString(HttpServletRequest request, String messageType) {
		HttpSession session= request.getSession();
    	return (String) session.getAttribute(messageType);
	}
	
	public void removeString(HttpServletRequest request, String messageType) {
		HttpSession session= request.getSession();
    	session.setAttribute(messageType, null);
	}
	
	public void setObject(HttpServletRequest request, String objectType, Object object) {
		HttpSession session= request.getSession();
    	session.setAttribute(objectType, object);
	}
	
	public Object getObject(HttpServletRequest request, String objectType) {
		HttpSession session= request.getSession();
    	return session.getAttribute(objectType);
	}
	
	public void removeObject(HttpServletRequest request, String objectType) {
		HttpSession session= request.getSession();
    	session.setAttribute(objectType, null);
	}

}
