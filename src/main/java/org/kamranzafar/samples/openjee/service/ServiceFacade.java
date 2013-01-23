package org.kamranzafar.samples.openjee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author kamran
 * 
 */
@Component
public class ServiceFacade {
	@Autowired
	private LoginService loginService;

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
}
