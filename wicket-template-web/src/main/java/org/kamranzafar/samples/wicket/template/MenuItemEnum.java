package org.kamranzafar.samples.wicket.template;

/**
 * @author kamran
 * 
 */
public enum MenuItemEnum {

	INDEX("Index", false), CKEDITOR("CKEditor", false), LOGOUT("Logout", false), NONE("", false);

	private String label;
	private boolean dropdown = false;

	MenuItemEnum(String label, boolean dropdown) {
		this.label = label;
		this.dropdown = dropdown;
	}

	public String getLabel() {
		return label;
	}

	public boolean isDropdown() {
		return dropdown;
	}

	@Override
	public String toString() {
		return label;
	}
}
