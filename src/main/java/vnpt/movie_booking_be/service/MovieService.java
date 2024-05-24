package vnpt.movie_booking_be.service;

import vnpt.movie_booking_be.dto.response.MovieResponse;

import java.util.List;

public interface MovieService {
    List<MovieResponse> getAllMovies();
}
