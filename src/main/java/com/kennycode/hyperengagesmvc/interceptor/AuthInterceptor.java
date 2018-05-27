package com.kennycode.hyperengagesmvc.interceptor;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	private List<String> unProtectedRoutes;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception {

		boolean checkSessionId = true;
		
		String contextPath = request.getContextPath();
		unProtectedRoutes = new ArrayList<String>();
		// List of route that doesn't need to check session
		unProtectedRoutes.add(contextPath + "/");
		unProtectedRoutes.add(contextPath + "/signin");
		//unProtectedRoutes.add(contextPath + "/signup");

		for (String route : unProtectedRoutes) {
			// if find one 'unProtectedRoute' then put false to check session and break the
			// loop, another way check session.
			if (request.getRequestURI().equals(route)) {
				System.out.println("FIND ONE "+route);
				checkSessionId = false;
				break;
			}
		}

		// should verify the Session to that route?
		if (checkSessionId) {
			String sessionId = (String) request.getSession().getAttribute("sessionId");
			System.out.println("SessionId: " + sessionId);
			if (sessionId == null || sessionId.equals("")) {
				response.sendRedirect(contextPath+"/");
				return false;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handle,
			ModelAndView model) {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {

	}
}
