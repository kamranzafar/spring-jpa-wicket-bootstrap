package org.kamranzafar.samples.wicket.template.rest.ckeditor;


import org.apache.wicket.protocol.http.servlet.MultipartServletWebRequest;
import org.apache.wicket.util.upload.FileItem;
import org.kamranzafar.samples.wicket.template.Image;
import org.wicketstuff.rest.annotations.MethodMapping;
import org.wicketstuff.rest.utils.http.HttpMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by kamran on 27/05/15.
 */
public class CKEditorResource extends BaseResource {
    private static final Logger logger = Logger.getLogger(CKEditorResource.class.getSimpleName());

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
