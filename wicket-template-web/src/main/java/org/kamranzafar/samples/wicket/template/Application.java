package org.kamranzafar.samples.wicket.template;

import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.kamranzafar.samples.wicket.template.pages.Index;
import org.kamranzafar.samples.wicket.template.pages.LoginView;
import org.kamranzafar.samples.wicket.template.rest.ckeditor.CKEditorResource;
import org.wicketstuff.springreference.SpringReferenceSupporter;

/**
 * @author kamran
 * 
 */
public class Application extends AuthenticatedWebApplication {
	@Override
	protected void init() {
		super.init();
		getComponentInstantiationListeners().add(new SpringComponentInjector(this));
		getMarkupSettings().setStripWicketTags(true);
		SpringReferenceSupporter.register(this);

		mountResource("/ckeditor", new ResourceReference("restReference") {
			CKEditorResource resource = new CKEditorResource();
			@Override
			public IResource getResource() {
				return resource;
			}

		});

		mountResource("/image/${id}", new ImageDownloadResourceReference());
		mountResource("/image/save", new ImageUploadResourceReference());
	}

	@Override
	public Session newSession(Request request, Response response) {
		return new UserSession(request);
	}

	@Override
	public Class<? extends Page> getHomePage() {
		return Index.class;
	}

	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
		return UserSession.class;
	}

	@Override
	protected Class<? extends WebPage> getSignInPageClass() {
		return LoginView.class;
	}
}
