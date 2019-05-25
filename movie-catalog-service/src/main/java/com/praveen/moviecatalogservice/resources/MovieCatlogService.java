package com.praveen.moviecatalogservice.resources;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.praveen.moviecatalogservice.models.CatlogItem;
import com.praveen.moviecatalogservice.models.Movie;
import com.praveen.moviecatalogservice.models.Rating;
import com.praveen.moviecatalogservice.models.UserRating;

@RestController
@RequestMapping("/catlog")
public class MovieCatlogService {
//check
	@Autowired
	private RestTemplate restTemplate;
	@RequestMapping("/{userId}")
	public List<CatlogItem> getCatlog(@PathVariable("userId") String userId){

		//RestTemplate restTemplate = new RestTemplate();
		//Movie movie =restTemplate.getForObject("http://localhost:8081/movies/foo",Movie.class);
		//get all rated movie IDs
		/*List<Rating> ratings= Arrays.asList(
					new Rating("1234",3),
				new Rating("1244",4));*/
//UserRating ratings= restTemplate.getForObject("http://localhost:8083/ratingsdata/users/"+userId,UserRating.class);
		UserRating ratings= restTemplate.getForObject("http://RATING-DATA-SERVICE/ratingsdata/users/"+userId,UserRating.class);
		//for each movie id call movie info service and get the details
		return ratings.getUserRating().stream().map(rating ->{
			//Movie movie=restTemplate.getForObject("http://localhost:8082/movies/"+rating.getMovieId(),Movie.class);
			Movie movie=restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/"+rating.getMovieId(),Movie.class);
			//put them together
			return new CatlogItem(movie.getName(),"GOOD",rating.getRating() );
		}
			).collect(Collectors.toList());

		//return  Collections.singletonList(new CatlogItem("Walle","Good",3));
		}
}
