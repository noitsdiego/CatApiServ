package com.tucatapi.catservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CatModel {
	private String id;
    private String name;
    private String description;
    private String ImageUrl;

    public CatModel() {
	}
    
	public CatModel(String id, String name, String description, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		ImageUrl = imageUrl;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return ImageUrl;
	}
	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}
    
}
