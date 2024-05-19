package vnpt.movie_booking_be.dto.reponse;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressRepone {
    private int id;
    private String street;
    private String ward;
    private String district;
    private String city;
}
