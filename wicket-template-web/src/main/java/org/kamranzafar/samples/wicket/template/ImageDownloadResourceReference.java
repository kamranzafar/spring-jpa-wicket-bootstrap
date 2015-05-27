package org.kamranzafar.samples.wicket.template;

/**
 * Created by kamran on 27/05/15.
 */

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.DynamicImageResource;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.util.string.StringValue;

public class ImageDownloadResourceReference extends BaseResourceReference {
    public ImageDownloadResourceReference() {
        super(ImageDownloadResourceReference.class, "imageDownload");
    }

    @Override
    public IResource getResource() {
        return new ImageDownloadResource();
    }

    private class ImageDownloadResource extends DynamicImageResource {

        @Override
        protected byte[] getImageData(Attributes attributes) {

            PageParameters parameters = attributes.getParameters();
            StringValue id = parameters.get("id");

            byte[] imageBytes = null;

            if (!id.isEmpty()) {
                imageBytes = deps.serviceFacade.getImageService().getImage(id.toInt()).getData();
            }

            return imageBytes;
        }

        @Override
        public boolean equals(Object that) {
            return that instanceof ImageDownloadResource;
        }
    }
}

