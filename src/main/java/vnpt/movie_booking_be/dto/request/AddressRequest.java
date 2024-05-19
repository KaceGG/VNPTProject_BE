package vnpt.movie_booking_be.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressRequest {
    private String street;
    private String ward;
    private String district;
    private String city;
}
