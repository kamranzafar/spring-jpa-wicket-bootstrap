package org.kamranzafar.samples.wicket.template.service.impl;

import org.kamranzafar.samples.wicket.template.dao.DaoManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kamran on 27/05/15.
 */
public abstract class BaseServiceImpl {
    @Autowired
    protected DaoManager daoManager;
}
