package com.movie.rating.model;

public class Catalog {
	private String id;
	private String title;
	private float rating;

	public Catalog() {
		super();
	}

	public Catalog(String id, String title, float rating) {
		super();
		this.id = id;
		this.title = title;
		this.rating = rating;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

}
