package org.kamranzafar.samples.openjee.pages;

import java.util.logging.Logger;

import org.apache.wicket.markup.html.WebPage;
import org.kamranzafar.samples.openjee.BootstrapNavBarPanel.MenuBuilder;
import org.kamranzafar.samples.openjee.MenuItemEnum;

/**
 * @author kamran
 * 
 */
public class LoginView extends WebPage {
	private static Logger logger = Logger.getLogger(LoginView.class.getName());

	public LoginView() {
		add(new MenuBuilder("navBar", LoginView.class, "Open J2EE Sample", "", MenuItemEnum.NONE).build());
		add(new LoginPanel("loginPanel", false));
	}
}
