package vnpt.movie_booking_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vnpt.movie_booking_be.models.Movie;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
    @Query("SELECT m FROM Movie m")
    List<Movie> findAllWithGenres();
}
