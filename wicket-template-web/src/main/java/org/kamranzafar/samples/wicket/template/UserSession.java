package org.kamranzafar.samples.wicket.template;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.request.Request;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.kamranzafar.samples.wicket.template.service.ServiceFacade;

/**
 * @author kamran
 * 
 */
public class UserSession extends AuthenticatedWebSession {
	@SpringBean
	private ServiceFacade serviceFacade;

	private User user;

	public UserSession(Request request) {
		super(request);
		Injector.get().inject(this);
	}

	@Override
	public boolean authenticate(String username, String password) {
		User user = serviceFacade.getLoginService().authenticate(username, password);

		if (user != null) {
			this.user = user;
			return true;
		}
		return false;
	}

	@Override
	public Roles getRoles() {
		Roles roles = new Roles();
		if (isSignedIn()) {
			roles.add(user.getRole());
		}
		return roles;
	}

	public User getLoggedInUser() {
		return user;
	}
}
