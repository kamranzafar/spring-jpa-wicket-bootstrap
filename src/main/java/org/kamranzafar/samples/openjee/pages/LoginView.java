package org.kamranzafar.samples.openjee.pages;

import java.util.logging.Logger;

import org.kamranzafar.samples.openjee.BasePage;
import org.kamranzafar.samples.openjee.MenuItemEnum;

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
