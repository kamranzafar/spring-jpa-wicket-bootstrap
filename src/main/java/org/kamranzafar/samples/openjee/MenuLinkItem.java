package org.kamranzafar.samples.openjee;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.Panel;

/**
 * @author kamran
 * 
 */
@SuppressWarnings("serial")
public class MenuLinkItem extends Panel {

	public MenuLinkItem(String id, BookmarkablePageLink<?> pageLink, boolean shouldBeActive) {
		super(id);
		add(pageLink);
		if (shouldBeActive) {
			add(new AttributeAppender("class", " active "));
		}
	}
}
