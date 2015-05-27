package org.kamranzafar.samples.wicket.template.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author kamran
 * 
 */
@Component
public class DaoManager {
	@Autowired
	private UserDao userDao;

	@Autowired
	private ImageDao imageDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public ImageDao getImageDao() {
		return imageDao;
	}

	public void setImageDao(ImageDao imageDao) {
		this.imageDao = imageDao;
	}
}
