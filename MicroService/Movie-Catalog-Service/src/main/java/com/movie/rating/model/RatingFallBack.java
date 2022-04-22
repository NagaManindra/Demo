package com.movie.rating.model;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RatingFallBack {
	@Autowired
	private RestTemplate template;

	@HystrixCommand(fallbackMethod = "getRatingFallBack")
	public RatingInfo getRating(String userId) {
		return template.getForObject("http://movie-rating/rating/user/" + userId, RatingInfo.class);
	}

	@SuppressWarnings("unused")
	private RatingInfo getRatingFallBack(String userId) {
		RatingInfo info = new RatingInfo();
		info.setRatings(Arrays.asList(new Rating(userId, "", 0)));
		return info;
	}

}
