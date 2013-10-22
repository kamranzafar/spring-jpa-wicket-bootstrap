package org.kamranzafar.samples.openjee.pages;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.kamranzafar.samples.openjee.BasePage;
import org.kamranzafar.samples.openjee.MenuItemEnum;

/**
 * @author kamran
 * 
 */
public class LogoutView extends BasePage {
	public LogoutView(final PageParameters parameters) {
		add(menuBuilder.withActiveMenu(MenuItemEnum.NONE).build());
		add(new BookmarkablePageLink<Void>("homePage", Index.class));
		getSession().invalidate();
	}
}
