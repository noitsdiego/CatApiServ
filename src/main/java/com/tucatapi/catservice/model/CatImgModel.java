package com.tucatapi.catservice.model;

public class CatImgModel {
	private String id;
    private String url;
    private String breedId;
    
    public CatImgModel() {
	}
    
	public CatImgModel(String id, String url, String breedId) {
		super();
		this.id = id;
		this.url = url;
		this.breedId = breedId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getBreedId() {
		return breedId;
	}
	public void setBreedId(String breedId) {
		this.breedId = breedId;
	}
    
    

}
