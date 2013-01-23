package org.kamranzafar.samples.openjee.pages;

import java.util.logging.Logger;

import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.kamranzafar.samples.openjee.BasePage;
import org.kamranzafar.samples.openjee.MenuItemEnum;

/**
 * @author kamran
 * 
 */
@AuthorizeInstantiation("USER")
public class Index extends BasePage {
	private static Logger logger = Logger.getLogger(Index.class.getName());

	public Index() {
	}

	@Override
	public MenuItemEnum getActiveMenu() {
		return MenuItemEnum.INDEX;
	}
}
