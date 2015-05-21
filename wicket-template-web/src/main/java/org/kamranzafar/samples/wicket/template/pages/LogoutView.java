package org.kamranzafar.samples.wicket.template.pages;

import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.kamranzafar.samples.wicket.template.BasePage;
import org.kamranzafar.samples.wicket.template.MenuItemEnum;

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
