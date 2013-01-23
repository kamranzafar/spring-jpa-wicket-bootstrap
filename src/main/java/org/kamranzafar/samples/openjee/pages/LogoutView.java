package org.kamranzafar.samples.openjee.pages;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.kamranzafar.samples.openjee.BootstrapNavBarPanel;
import org.kamranzafar.samples.openjee.MenuItemEnum;

/**
 * @author kamran
 * 
 */
public class LogoutView extends WebPage {
	public LogoutView(final PageParameters parameters) {
		add(new BootstrapNavBarPanel.MenuBuilder("navBar", Index.class, "Open J2EE Sample", "", MenuItemEnum.NONE)
				.build());
		add(new BookmarkablePageLink<Void>("homePage", Index.class));
		getSession().invalidate();
	}
}
