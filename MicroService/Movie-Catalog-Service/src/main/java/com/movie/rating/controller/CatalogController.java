package com.movie.rating.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.rating.model.Catalog;
import com.movie.rating.model.Movie;
import com.movie.rating.model.MovieFallBack;
import com.movie.rating.model.RatingFallBack;
import com.movie.rating.model.RatingInfo;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
	@Autowired
	private MovieFallBack movieFallBack;
	@Autowired
	private RatingFallBack ratingFallBack;

	@GetMapping("user/{userId}")
	public List<Catalog> getCatalog(@PathVariable("userId") String userId) {
		RatingInfo ratingInfo = ratingFallBack.getRating(userId);
		return ratingInfo.getRatings().stream().map(rating -> {
			Movie movie = movieFallBack.getMovie(rating);
			return new Catalog(movie.getId(), movie.getOverview(), rating.getRating());
		}).collect(Collectors.toList());
	}

}
