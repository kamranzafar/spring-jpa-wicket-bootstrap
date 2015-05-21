package org.kamranzafar.samples.wicket.template;

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

		String cssClass = message.getLevelAsString().toLowerCase();

		cssClass = cssClass.equals("info") ? "success" : cssClass;

		/*
		 * Bootstrap alert css
		 */
		add(new AttributeModifier("style", "display:block"));
		add(new AttributeModifier("class", "alert alert-" + cssClass));

		return newMessageDisplayComponent;
	}
}
