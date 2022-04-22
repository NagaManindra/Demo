package com.movie.rating.model;

import java.util.ArrayList;
import java.util.List;

public class RatingInfo {

	List<Rating> ratings = new ArrayList<>();

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

}
