package com.movie.rating.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.rating.model.Rating;
import com.movie.rating.model.RatingInfo;

@RestController
@RequestMapping("/rating")
public class RatingController {

	List<Rating> list = Arrays.asList(new Rating("123", "250", 3.5f), new Rating("125", "253", 3.0f),
			new Rating("123", "292", 2.5f), new Rating("125", "153", 4.0f), new Rating("124", "350", 3.5f),
			new Rating("124", "453", 3.0f), new Rating("122", "250", 3.5f), new Rating("122", "253", 3.0f),
			new Rating("121", "250", 3.5f), new Rating("121", "253", 3.0f), new Rating("120", "250", 3.5f),
			new Rating("120", "253", 3.0f));

	@GetMapping("/user/{userId}")
	public RatingInfo getRatingInfo(@PathVariable("userId") String userId) {
		RatingInfo ratingInfo = new RatingInfo();
		ratingInfo.setRatings(list.stream().filter(x -> userId.equals(x.getUserId()))
				.map(p -> new Rating(p.getUserId(), p.getMovieId(), p.getRating())).collect(Collectors.toList()));
		return ratingInfo;
	}

}
