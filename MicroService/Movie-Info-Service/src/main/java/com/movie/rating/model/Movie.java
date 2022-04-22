package com.movie.rating.model;

public class Movie {

	private String id;
	private String title;
	private String overview;
	private String genres;

	public Movie() {
		super();
	}

	public Movie(String id, String title, String overview, String genres) {
		super();
		this.id = id;
		this.title = title;
		this.overview = overview;
		this.genres = genres;
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

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getGenres() {
		return genres;
	}

	public void setGenres(String genres) {
		this.genres = genres;
	}

}
