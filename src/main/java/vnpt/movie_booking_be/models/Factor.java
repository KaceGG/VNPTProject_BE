package vnpt.movie_booking_be.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Factor {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int id;
	 
	 @Enumerated(EnumType.STRING)
	 private DayType dayType;
	 
	 private float heso;
	 
	 @ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "cinema_id")
	 private Cinema cinema;
}
