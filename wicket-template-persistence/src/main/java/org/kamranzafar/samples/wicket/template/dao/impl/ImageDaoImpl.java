package org.kamranzafar.samples.wicket.template.dao.impl;

import org.kamranzafar.samples.wicket.template.Image;
import org.kamranzafar.samples.wicket.template.dao.BaseDao;
import org.kamranzafar.samples.wicket.template.dao.ImageDao;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * Created by kamran on 27/05/15.
 */
@Service
public class ImageDaoImpl extends BaseDao<Image, Serializable> implements ImageDao {
}
