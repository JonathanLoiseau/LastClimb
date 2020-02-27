package com.last_climb.climb.model.form;

public class SiteForm {

	private String name;
	private Long id;
	private String localisation;
	private byte[] siteimg;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocalisation() {
		return localisation;
	}

	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}

	public byte[] getSiteimg() {
		return siteimg;
	}

	public void setSiteimg(byte[] siteimg) {
		this.siteimg = siteimg;
	}

	@Override
	public String toString() {
		return "SiteForm [name=" + name + ", id=" + id + ", localisation=" + localisation + "]";
	}

}
