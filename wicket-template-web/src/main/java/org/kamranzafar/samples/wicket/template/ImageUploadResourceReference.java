package org.kamranzafar.samples.wicket.template;

/**
 * Created by kamran on 27/05/15.
 */

import org.apache.wicket.protocol.http.servlet.ServletWebRequest;
import org.apache.wicket.request.resource.AbstractResource;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.util.lang.Bytes;
import org.apache.wicket.util.upload.FileItem;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * A resource reference which serves images by their name.
 */
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
                Map<String, List<FileItem>> files = ((ServletWebRequest) attributes.getRequest())
                        .newMultipartWebRequest(Bytes.megabytes(100), "ignored").getFiles();

                for (String key : files.keySet()) {
                    logger.info("++++++++++++++++++++ " + key + " : " + files.get(key));
                }

                responseHtml.append("<b>File uploaded</b>");
            } catch (Throwable t) {
                t.printStackTrace();
                responseHtml.append("<b>Error" + t.getMessage() + "</b>");
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


