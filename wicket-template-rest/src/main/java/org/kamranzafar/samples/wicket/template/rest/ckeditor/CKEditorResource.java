package org.kamranzafar.samples.wicket.template.rest.ckeditor;


import org.kamranzafar.samples.wicket.template.Image;
import org.wicketstuff.rest.annotations.MethodMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kamran on 27/05/15.
 */
public class CKEditorResource extends BaseResource {
    @MethodMapping("/images")
    public List<ImageDto> getImages() {
        List<ImageDto> imageDtos = new ArrayList<ImageDto>();
        List<Image> images = deps.serviceFacade.getImageService().getAllImages();

        for (Image image : images) {
            ImageDto imageDto = new ImageDto();
            imageDto.setImage("/wicket-template-web/image/" + image.getId());

            imageDtos.add(imageDto);
        }

        return imageDtos;
    }
}
