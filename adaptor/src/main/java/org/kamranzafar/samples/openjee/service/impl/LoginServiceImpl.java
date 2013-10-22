package org.kamranzafar.samples.openjee.service.impl;

import org.kamranzafar.samples.openjee.User;
import org.kamranzafar.samples.openjee.dao.DaoManager;
import org.kamranzafar.samples.openjee.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kamran
 * 
 */
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	private DaoManager daoManager;

	@Override
	public User authenticate(String username, String password) {
		return daoManager.getUserDao().getUserByUsernameAndPassword(username, password);
	}
}
