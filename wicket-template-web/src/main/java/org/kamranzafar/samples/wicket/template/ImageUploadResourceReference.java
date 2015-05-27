package org.kamranzafar.samples.wicket.template;

/**
 * Created by kamran on 27/05/15.
 */

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.wicket.protocol.http.servlet.ServletWebRequest;
import org.apache.wicket.request.resource.AbstractResource;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.util.io.IOUtils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;


public class ImageUploadResourceReference extends BaseResourceReference {
    private static final Logger logger = Logger.getLogger(ImageUploadResourceReference.class.getSimpleName());

    public ImageUploadResourceReference() {
        super(ImageUploadResourceReference.class, "imageUpload");
    }

    @Override
    public IResource getResource() {
        return new ImageUploadResource();
    }

    private class ImageUploadResource extends AbstractResource {
        @Override
        public boolean equals(Object that) {
            return that instanceof ImageUploadResource;
        }

        @Override
        protected ResourceResponse newResourceResponse(Attributes attributes) {
            ResourceResponse response = new ResourceResponse();
            response.setContentType("text/html");

            final StringBuilder responseHtml = new StringBuilder();

            try {
                List<FileItem> fileItems = new ServletFileUpload(new DiskFileItemFactory())
                        .parseRequest(((ServletWebRequest) attributes.getRequest()).getContainerRequest());

                for (FileItem fi : fileItems) {
                    if (!fi.isFormField()) {
                        Image image = new Image();
                        image.setData(IOUtils.toByteArray(fi.getInputStream()));
                        image.setName(fi.getName());
                        image.setContentType(fi.getContentType());

                        deps.serviceFacade.getImageService().saveImage(image);
                    }
                }

                responseHtml.append("<b>File uploaded</b>");
            } catch (Throwable t) {
                t.printStackTrace();
                responseHtml.append("<b>Error: " + t.getMessage() + "</b>");
            }

            response.setWriteCallback(new WriteCallback() {
                @Override
                public void writeData(Attributes attributes) throws IOException {
                    attributes.getResponse().write(responseHtml.toString());
                }
            });

            return response;
        }
    }
}


