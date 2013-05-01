package org.kamranzafar.samples.openjee.pages;

import org.apache.wicket.RestartResponseException;
import org.apache.wicket.authentication.IAuthenticationStrategy;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.CompoundPropertyModel;
import org.kamranzafar.samples.openjee.CssFeedbackPanel;

/**
 * @author kamran
 * 
 */
public class LoginPanel extends Panel {
	private static final long serialVersionUID = 1L;

	private static final String SIGN_IN_FORM = "loginForm";

	private boolean includeRememberMe = true;

	private boolean rememberMe = false;

	private String password;

	private String username;

	public LoginPanel(final String id) {
		this(id, true);
	}

	public LoginPanel(final String id, final boolean includeRememberMe) {
		super(id);

		this.includeRememberMe = includeRememberMe;

		add(new CssFeedbackPanel("feedback"));
		add(new LoginForm(SIGN_IN_FORM));
	}

	protected LoginForm getForm() {
		return (LoginForm) get(SIGN_IN_FORM);
	}

	/**
	 * @see org.apache.wicket.Component#onBeforeRender()
	 */
	@Override
	protected void onBeforeRender() {
		// logged in already?
		if (isSignedIn() == false) {
			IAuthenticationStrategy authenticationStrategy = getApplication().getSecuritySettings()
					.getAuthenticationStrategy();
			// get username and password from persistence store
			String[] data = authenticationStrategy.load();

			if ((data != null) && (data.length > 1)) {
				// try to sign in the user
				if (signIn(data[0], data[1])) {
					username = data[0];
					password = data[1];

					// logon successful. Continue to the original destination
					continueToOriginalDestination();
					// Ups, no original destination. Go to the home page
					throw new RestartResponseException(getSession().getPageFactory().newPage(
							getApplication().getHomePage()));
				} else {
					// the loaded credentials are wrong. erase them.
					authenticationStrategy.remove();
				}
			}
		}

		super.onBeforeRender();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public boolean getRememberMe() {
		return rememberMe;
	}

	public void setRememberMe(final boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	private boolean signIn(String username, String password) {
		return AuthenticatedWebSession.get().signIn(username, password);
	}

	private boolean isSignedIn() {
		return AuthenticatedWebSession.get().isSignedIn();
	}

	protected void onSignInFailed() {
		error(getLocalizer().getString("signInFailed", this, "Sign in failed"));
	}

	protected void onSignInSucceeded() {
		continueToOriginalDestination();
		setResponsePage(getApplication().getHomePage());
	}

	public final class LoginForm extends StatelessForm<LoginPanel> {
		private static final long serialVersionUID = 1L;

		public LoginForm(final String id) {
			super(id);

			setModel(new CompoundPropertyModel<LoginPanel>(LoginPanel.this));

			add(new TextField<String>("username").setRequired(true));
			add(new PasswordTextField("password"));

			WebMarkupContainer rememberMeRow = new WebMarkupContainer("rememberMeRow");
			add(rememberMeRow);

			rememberMeRow.add(new CheckBox("rememberMe"));
			rememberMeRow.setVisible(includeRememberMe);
		}

		@Override
		public final void onSubmit() {
			IAuthenticationStrategy strategy = getApplication().getSecuritySettings().getAuthenticationStrategy();

			if (signIn(getUsername(), getPassword())) {
				if (rememberMe == true) {
					strategy.save(username, password);
				} else {
					strategy.remove();
				}

				onSignInSucceeded();
			} else {
				onSignInFailed();
				strategy.remove();
			}
		}
	}
}
