package com.movie.rating.model;

public class Genres {

	private String name;

	public Genres() {
		super();
	}

	public Genres(String name) {
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
		return name;
	}

}
