package org.kamranzafar.samples.openjee;

import java.io.Serializable;
import java.util.Collection;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;

import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;

/**
 * @author kamran
 * 
 */
public class BootstrapNavBarPanel extends Panel {

	private BootstrapNavBarPanel(final MenuBuilder builder) {
		super(builder.id);

		BookmarkablePageLink<Void> homePageLink = new BookmarkablePageLink<Void>("homePageLink", builder.homePage);
		homePageLink.add(new Label("label", builder.applicationName));
		add(homePageLink);
		add(new Label("userName", builder.userName));

		RepeatingView repeatingView = new RepeatingView("menuItems");

		for (MenuItemEnum item : builder.linksMap.keySet()) {
			boolean shouldBeActive = item.equals(builder.activeMenuItem);

			Collection<BookmarkablePageLink<?>> linksInThisMenuItem = builder.linksMap.get(item);

			if (!item.isDropdown()) {
				BookmarkablePageLink<?> pageLink = Iterables.get(linksInThisMenuItem, 0);

				MenuLinkItem menuLinkItem = new MenuLinkItem(repeatingView.newChildId(), pageLink, shouldBeActive);
				repeatingView.add(menuLinkItem);
			} else {
				repeatingView.add(new MenuDropdownItem(repeatingView.newChildId(), item, linksInThisMenuItem,
						shouldBeActive));
			}
		}

		add(repeatingView);
	}

	public static class MenuBuilder implements Serializable {
		private final String id;
		private final Class<? extends Page> homePage;
		private final String applicationName;
		private String userName;
		private MenuItemEnum activeMenuItem;

		private final Multimap<MenuItemEnum, BookmarkablePageLink<?>> linksMap = LinkedHashMultimap.create();

		public MenuBuilder(String id, Class<? extends Page> homePage, String applicationName, String userName,
				MenuItemEnum activeMenuItem) {
			this(id, homePage, applicationName);
			this.userName = userName;
			this.activeMenuItem = activeMenuItem;
		}

		public MenuBuilder(String id, Class<? extends Page> homePage, String applicationName) {
			this.id = id;
			this.homePage = homePage;
			this.applicationName = applicationName;
		}

		public MenuBuilder withMenuItem(MenuItemEnum menuItem, Class<? extends Page> pageToLink) {
			withMenuItem(menuItem, pageToLink, menuItem.getLabel());
			return this;
		}

		public MenuBuilder withMenuItem(MenuItemEnum menuItem, Class<? extends Page> pageToLink, String label) {
			BookmarkablePageLink<Page> link = new BookmarkablePageLink<Page>("link", pageToLink);
			link.setBody(new Model<String>(label));
			linksMap.put(menuItem, link);
			return this;
		}

		public MenuBuilder withUser(String username) {
			this.userName = username;
			return this;
		}

		public MenuBuilder withActiveMenu(MenuItemEnum activeMenu) {
			this.activeMenuItem = activeMenu;
			return this;
		}

		public BootstrapNavBarPanel build() {
			return new BootstrapNavBarPanel(this);
		}
	}
}
