package org.kamranzafar.samples.wicket.template.service;

import org.kamranzafar.samples.wicket.template.Image;

import java.util.List;

/**
 * Created by kamran on 27/05/15.
 */
public interface ImageService {
    public Image getImage(int id);

    public void saveImage(Image image);

    public List<Image> getAllImages();
}
