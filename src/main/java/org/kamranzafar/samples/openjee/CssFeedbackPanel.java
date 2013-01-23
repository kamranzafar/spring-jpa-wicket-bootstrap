package org.kamranzafar.samples.openjee;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.IFeedbackMessageFilter;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

/**
 * @author kamran
 * 
 */
public class CssFeedbackPanel extends FeedbackPanel {

	public CssFeedbackPanel(final String id, final IFeedbackMessageFilter filter) {
		super(id, filter);
	}

	public CssFeedbackPanel(final String id) {
		super(id);
	}

	@Override
	protected Component newMessageDisplayComponent(final String id, final FeedbackMessage message) {
		final Component newMessageDisplayComponent = super.newMessageDisplayComponent(id, message);

		/*
		 * Bootstrap alert css
		 */
		add(new AttributeModifier("style", "display:block"));
		add(new AttributeModifier("class", "alert alert-" + message.getLevelAsString().toLowerCase()));

		return newMessageDisplayComponent;
	}
}
