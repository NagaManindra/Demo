package com.movie.rating.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MovieFallBack {
	@Autowired
	private RestTemplate template;

	@HystrixCommand(fallbackMethod = "getMovieFallBack")
	public Movie getMovie(Rating rating) {
		return template.getForObject("http://movie-info/movie/" + rating.getMovieId(), Movie.class);
	}

	@SuppressWarnings("unused")
	private Movie getMovieFallBack(Rating rating) {
		return new Movie(rating.getMovieId(), "movie not found", "...", "..");
	}

}
