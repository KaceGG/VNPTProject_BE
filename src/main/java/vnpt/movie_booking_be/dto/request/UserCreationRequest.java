package vnpt.movie_booking_be.dto.request;

import lombok.*;
import vnpt.movie_booking_be.dto.reponse.AddressRepone;
import vnpt.movie_booking_be.models.Address;
import vnpt.movie_booking_be.models.Membership;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreationRequest {
    private String name;
    private String email;
    private String phone;
    private String password;
    private AddressRequest address;
    private Membership membership;
}
