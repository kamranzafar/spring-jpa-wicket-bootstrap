package org.kamranzafar.samples.wicket.template.service;

import org.kamranzafar.samples.wicket.template.User;

/**
 * @author kamran
 * 
 */
public interface LoginService {
	public User authenticate(String username, String password);
}
