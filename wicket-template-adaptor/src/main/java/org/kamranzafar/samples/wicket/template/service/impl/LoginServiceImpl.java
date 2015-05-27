package org.kamranzafar.samples.wicket.template.service.impl;

import org.kamranzafar.samples.wicket.template.User;
import org.kamranzafar.samples.wicket.template.dao.DaoManager;
import org.kamranzafar.samples.wicket.template.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kamran
 * 
 */
@Service
public class LoginServiceImpl extends BaseServiceImpl implements LoginService {
	@Override
	public User authenticate(String username, String password) {
		return daoManager.getUserDao().getUserByUsernameAndPassword(username, password);
	}
}
