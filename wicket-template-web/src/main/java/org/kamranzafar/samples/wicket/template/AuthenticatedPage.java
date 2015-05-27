package org.kamranzafar.samples.wicket.template;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.kamranzafar.samples.wicket.template.pages.ckeditor.CKEditorPage;
import org.kamranzafar.samples.wicket.template.pages.Index;
import org.kamranzafar.samples.wicket.template.pages.LogoutView;

public abstract class AuthenticatedPage extends BasePage {
    public AuthenticatedPage() {
        this.menuBuilder.withActiveMenu(getActiveMenu()).withUser(getLoggedInUser())
                .withMenuItem(MenuItemEnum.INDEX, Index.class).withMenuItem(MenuItemEnum.LOGOUT, LogoutView.class)
                .withMenuItem(MenuItemEnum.CKEDITOR, CKEditorPage.class);

        add(this.menuBuilder.build());
    }

    public String getLoggedInUser() {
        return ((UserSession) AuthenticatedWebSession.get()).getLoggedInUser().getUsername();
    }

    public abstract MenuItemEnum getActiveMenu();
}
