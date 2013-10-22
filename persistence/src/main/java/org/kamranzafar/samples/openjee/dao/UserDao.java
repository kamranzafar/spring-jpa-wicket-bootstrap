package org.kamranzafar.samples.openjee.dao;

import java.io.Serializable;

import org.kamranzafar.samples.openjee.User;

/**
 * @author kamran
 * 
 */
public interface UserDao extends Dao<User, Serializable> {
	public User getUserByUsernameAndPassword(String username, String password);
}
