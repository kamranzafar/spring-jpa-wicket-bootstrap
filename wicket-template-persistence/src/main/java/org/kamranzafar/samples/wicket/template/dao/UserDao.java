package org.kamranzafar.samples.wicket.template.dao;

import java.io.Serializable;

import org.kamranzafar.samples.wicket.template.User;

/**
 * @author kamran
 * 
 */
public interface UserDao extends Dao<User, Serializable> {
	public User getUserByUsernameAndPassword(String username, String password);
}
