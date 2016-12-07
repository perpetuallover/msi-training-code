package com.mercury.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;


public class PostSuccessfulAuthenticationHandler extends SavedRequestAwareAuthenticationSuccessHandler {
	
	@SuppressWarnings("unchecked")
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = authentication.getName();
		session.setAttribute("username", username);
		List<SimpleGrantedAuthority> list = (List<SimpleGrantedAuthority>)authentication.getAuthorities();
		if (list.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
			this.setDefaultTargetUrl("/admin.html");
		} else {
			this.setDefaultTargetUrl("/main.html");
		}
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
