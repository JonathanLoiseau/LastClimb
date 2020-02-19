package com.last_climb.climb.model.form;

public class SiteForm {

	private String name;
	private Long id;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
