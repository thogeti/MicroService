package com.praveen.movieinfoservice.models;

public class Movie {

	private String MovieId;
	private String name;


	public Movie() {
		super();
	}
	public Movie(String movieId, String name) {
		super();
		this.MovieId = movieId;
		this.name = name;
	}
	public String getMovieId() {
		return MovieId;
	}
	public void setMovieId(String movieId) {
		MovieId = movieId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


}
