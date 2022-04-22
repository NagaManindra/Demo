package com.movie.rating.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.movie.rating.model.Catalog;
import com.movie.rating.model.Movie;
import com.movie.rating.model.RatingInfo;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

	@Autowired
	private RestTemplate template;

	@GetMapping("user/{userId}")
	public List<Catalog> getCatalog(@PathVariable("userId") String userId) {
		RatingInfo ratingInfo = template.getForObject("http://localhost:9002/rating/user/" + userId, RatingInfo.class);
		return ratingInfo.getRatings().stream().map(rating -> {
			Movie movie = template.getForObject("http://localhost:9001/movie/" + rating.getMovieId(), Movie.class);
			return new Catalog(movie.getId(), movie.getOverview(), rating.getRating());
		}).collect(Collectors.toList());
	}
}
