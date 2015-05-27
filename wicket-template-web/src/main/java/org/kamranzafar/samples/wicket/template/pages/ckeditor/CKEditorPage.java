package org.kamranzafar.samples.wicket.template.pages.ckeditor;

import org.kamranzafar.samples.wicket.template.AuthenticatedPage;
import org.kamranzafar.samples.wicket.template.MenuItemEnum;

/**
 * Created by kamran on 27/05/15.
 */
public class CKEditorPage extends AuthenticatedPage {

    @Override
    public MenuItemEnum getActiveMenu() {
        return MenuItemEnum.CKEDITOR;
    }
}
