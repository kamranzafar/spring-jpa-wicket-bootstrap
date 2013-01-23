package org.kamranzafar.samples.openjee.service;

import org.kamranzafar.samples.openjee.User;

/**
 * @author kamran
 * 
 */
public interface LoginService {
	public User authenticate(String username, String password);
}
