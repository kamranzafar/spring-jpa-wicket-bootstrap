package org.kamranzafar.samples.wicket.template.rest.ckeditor;

import java.io.Serializable;

/**
 * Created by kamran on 27/05/15.
 */
public class ImageDto implements Serializable {
    private String image;
    private String thumb;
    private String folder;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }
}
