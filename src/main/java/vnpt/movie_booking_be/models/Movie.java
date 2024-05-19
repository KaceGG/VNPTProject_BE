package vnpt.movie_booking_be.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Movie{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    private String image;
    private String trailer;
    private String director;
    private String cast;
    private int duration;
    private float rating;
    private LocalDateTime releaseDate;
    private LocalDateTime endDate;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "movie", orphanRemoval = true)
    private List<Screening> screenings = new ArrayList<>();
}