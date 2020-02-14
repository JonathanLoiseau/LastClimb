package com.last_climb.climb.model.form;

public class SiteForm {

	private String name;

	public SiteForm() {
	}

	public SiteForm(String name) {
		super();

		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "SiteForm [name=" + name + "]";
	}

}
