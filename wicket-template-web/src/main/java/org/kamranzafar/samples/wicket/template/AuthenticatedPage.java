package org.kamranzafar.samples.wicket.template;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.kamranzafar.samples.wicket.template.pages.Index;
import org.kamranzafar.samples.wicket.template.pages.LogoutView;

public abstract class AuthenticatedPage extends BasePage {
	public AuthenticatedPage() {
		menuBuilder.withActiveMenu(getActiveMenu()).withUser(getLoggedInUser())
				.withMenuItem(MenuItemEnum.INDEX, Index.class).withMenuItem(MenuItemEnum.LOGOUT, LogoutView.class);

		add(menuBuilder.build());
	}

	public String getLoggedInUser() {
		return ((UserSession) AuthenticatedWebSession.get()).getLoggedInUser().getUsername();
	}

	public abstract MenuItemEnum getActiveMenu();
}
