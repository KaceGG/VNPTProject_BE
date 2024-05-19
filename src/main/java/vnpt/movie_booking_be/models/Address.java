package vnpt.movie_booking_be.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String street;
    private String ward;
    private String district;
    private String city;

    @OneToOne(mappedBy = "address")
    private User user;
    
    @OneToOne(mappedBy = "address")
    private Cinema cinema;
}
