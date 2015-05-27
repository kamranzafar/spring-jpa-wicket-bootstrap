package org.kamranzafar.samples.wicket.template.service.impl;

import org.kamranzafar.samples.wicket.template.Image;
import org.kamranzafar.samples.wicket.template.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kamran on 27/05/15.
 */
@Service
public class ImageServiceImpl extends BaseServiceImpl implements ImageService {
    @Override
    public Image getImage(int id) {
        return daoManager.getImageDao().findById(id);
    }

    @Override
    @Transactional
    public void saveImage(Image image) {
        daoManager.getImageDao().persist(image);
    }

    @Override
    public List<Image> getAllImages() {
        return new ArrayList<Image>(daoManager.getImageDao().findAll());
    }
}
