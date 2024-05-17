package vnpt.movie_booking_be.models;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Screening implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private LocalDateTime start;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "auditorium_id")
    private Auditorium auditorium;

    @OneToOne(mappedBy = "screening")
    private Ticket ticket;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "screening", orphanRemoval = true)
    private List<Movie> movies = new ArrayList<>();
}
