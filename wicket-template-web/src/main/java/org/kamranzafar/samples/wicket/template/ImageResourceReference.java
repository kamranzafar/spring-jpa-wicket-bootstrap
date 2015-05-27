package org.kamranzafar.samples.wicket.template;

/**
 * Created by kamran on 27/05/15.
 */

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.DynamicImageResource;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.string.StringValue;
import org.kamranzafar.samples.wicket.template.service.ServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.wicketstuff.springreference.AbstractSpringDependencies;

/**
 * A resource reference which serves images by their name.
 */
public class ImageResourceReference extends ResourceReference {

    static class Deps extends AbstractSpringDependencies {
        @Autowired
        transient ServiceFacade serviceFacade;
    }

    private final Deps deps = new Deps();

    public ImageResourceReference() {
        super(ImageResourceReference.class, "imagesDemo");
    }

    @Override
    public IResource getResource() {
        return new ImageResource();
    }

    /**
     * A resource which shows how to return back the image as bytes.
     * For the demo it generates the image on the fly but in real life the
     * image can be read from DB, file system, Internet, ...
     */
    private class ImageResource extends DynamicImageResource {

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

        // Needed by ResourceMapper to be able to match the request Url with
        // the mounted ResourceReference
        @Override
        public boolean equals(Object that) {
            return that instanceof ImageResource;
        }
    }
}

