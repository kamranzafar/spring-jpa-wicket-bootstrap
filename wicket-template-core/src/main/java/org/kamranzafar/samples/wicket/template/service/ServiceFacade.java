package org.kamranzafar.samples.wicket.template.service;

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

	@Autowired
	private ImageService imageService;

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public ImageService getImageService() {
		return imageService;
	}

	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}
}
