package org.kamranzafar.samples.wicket.template.pages;

import java.util.logging.Logger;

import org.kamranzafar.samples.wicket.template.BasePage;
import org.kamranzafar.samples.wicket.template.MenuItemEnum;

/**
 * @author kamran
 * 
 */
public class LoginView extends BasePage {
	private static Logger logger = Logger.getLogger(LoginView.class.getName());

	public LoginView() {
		add(menuBuilder.withActiveMenu(MenuItemEnum.NONE).build());
		add(new LoginPanel("loginPanel", false));
	}
}
