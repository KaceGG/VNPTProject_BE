package vnpt.movie_booking_be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vnpt.movie_booking_be.dto.response.MovieResponse;
import vnpt.movie_booking_be.mapper.MovieMapper;
import vnpt.movie_booking_be.models.Movie;
import vnpt.movie_booking_be.repository.MovieRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService{
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List<MovieResponse> getAllMovies() {
        List<Movie> movies = movieRepository.findAllWithGenres();
        return movies.stream()
                .map(movie -> movieMapper.movieToMovieResponse(movie))
                .collect(Collectors.toList());
    }
}
