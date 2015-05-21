package org.kamranzafar.samples.wicket.template;

import org.apache.wicket.Application;
import org.apache.wicket.markup.html.WebPage;
import org.kamranzafar.samples.wicket.template.pages.Index;

/**
 * @author kamran
 * 
 */
public abstract class BasePage extends WebPage {
	protected final String APPLICATION_TITLE = "application.title";
	protected BootstrapNavBarPanel.MenuBuilder menuBuilder;

	public BasePage() {
		menuBuilder = new BootstrapNavBarPanel.MenuBuilder("navBar", Index.class, Application.get()
				.getResourceSettings().getLocalizer().getString(APPLICATION_TITLE, null));
	}
}
