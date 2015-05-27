package org.kamranzafar.samples.wicket.template;

import org.apache.wicket.request.resource.ResourceReference;
import org.kamranzafar.samples.wicket.template.service.ServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.wicketstuff.springreference.AbstractSpringDependencies;

/**
 * Created by kamran on 27/05/15.
 */
public abstract class BaseResourceReference extends ResourceReference {
    static class Deps extends AbstractSpringDependencies {
        @Autowired
        transient ServiceFacade serviceFacade;
    }

    protected final Deps deps = new Deps();

    public BaseResourceReference(Class<?> scope, String name) {
        super(scope, name);
    }
}
