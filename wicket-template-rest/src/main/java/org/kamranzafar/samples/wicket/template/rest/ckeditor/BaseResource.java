package org.kamranzafar.samples.wicket.template.rest.ckeditor;

import org.kamranzafar.samples.wicket.template.service.ServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.wicketstuff.rest.resource.gson.GsonRestResource;
import org.wicketstuff.springreference.AbstractSpringDependencies;

/**
 * Created by kamran on 27/05/15.
 */
public abstract class BaseResource extends GsonRestResource {
    static class Deps extends AbstractSpringDependencies {
        @Autowired
        transient ServiceFacade serviceFacade;
    }

    protected final Deps deps = new Deps();
}
