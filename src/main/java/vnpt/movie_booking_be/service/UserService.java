package vnpt.movie_booking_be.service;

import vnpt.movie_booking_be.dto.request.UserCreationRequest;
import vnpt.movie_booking_be.models.User;

public interface UserService {
    User createUser(UserCreationRequest request);
}
