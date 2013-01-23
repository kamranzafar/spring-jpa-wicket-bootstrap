package org.kamranzafar.samples.openjee;

/**
 * @author kamran
 * 
 */
public enum MenuItemEnum {

	INDEX("Index", false), LOGOUT("Logout", false), NONE("", false);

	private String label;
	private boolean dropdown = false;

	private MenuItemEnum(String label, boolean dropdown) {
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
