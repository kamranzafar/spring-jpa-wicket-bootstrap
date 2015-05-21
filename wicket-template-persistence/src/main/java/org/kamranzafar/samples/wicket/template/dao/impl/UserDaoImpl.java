package org.kamranzafar.samples.wicket.template.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.kamranzafar.samples.wicket.template.User;
import org.kamranzafar.samples.wicket.template.dao.BaseDao;
import org.kamranzafar.samples.wicket.template.dao.UserDao;
import org.springframework.stereotype.Service;

/**
 * @author kamran
 * 
 */
@Service
public class UserDaoImpl extends BaseDao<User, Serializable> implements UserDao {

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		List<User> ul = entityManager.createNamedQuery("UserByUsernameAndPassword").setParameter("uname", username)
				.setParameter("passwd", password).getResultList();

		if (ul.size() > 0) {
			return ul.get(0);
		}
		return null;
	}
}
