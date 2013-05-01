package org.kamranzafar.samples.openjee;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.kamranzafar.samples.openjee.BootstrapNavBarPanel.MenuBuilder;
import org.kamranzafar.samples.openjee.pages.Index;
import org.kamranzafar.samples.openjee.pages.LogoutView;

public abstract class AuthenticatedPage extends BasePage {
	public AuthenticatedPage() {

		MenuBuilder b = new BootstrapNavBarPanel.MenuBuilder("navBar", Index.class, "Open J2EE Sample",
				getLoggedInUser(), getActiveMenu()).withMenuItem(MenuItemEnum.INDEX, Index.class);

		b.withMenuItem(MenuItemEnum.LOGOUT, LogoutView.class);

		add(b.build());
	}

	public String getLoggedInUser() {
		return ((UserSession) AuthenticatedWebSession.get()).getLoggedInUser().getUsername();
	}

	public abstract MenuItemEnum getActiveMenu();
}
