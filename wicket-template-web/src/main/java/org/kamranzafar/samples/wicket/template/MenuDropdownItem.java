package org.kamranzafar.samples.wicket.template;

import java.util.Collection;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;

/**
 * @author kamran
 * 
 */
@SuppressWarnings("serial")
public class MenuDropdownItem extends Panel {

	public MenuDropdownItem(String id, MenuItemEnum currentMenuItem,
			Collection<BookmarkablePageLink<?>> linksInMenuItem, boolean shouldBeActive) {
		super(id);

		WebMarkupContainer itemContainer = new WebMarkupContainer("itemContainer");
		if (shouldBeActive) {
			itemContainer.add(new AttributeAppender("class", " active "));
		}
		itemContainer.add(new Label("label", currentMenuItem.getLabel()));

		RepeatingView repeatingView = new RepeatingView("itemLinks");

		for (BookmarkablePageLink<?> link : linksInMenuItem) {
			MenuLinkItem menuLinkItem = new MenuLinkItem(repeatingView.newChildId(), link, false);
			repeatingView.add(menuLinkItem);
		}

		itemContainer.add(repeatingView);
		add(itemContainer);
	}
}
