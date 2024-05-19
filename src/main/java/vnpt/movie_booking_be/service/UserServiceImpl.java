package vnpt.movie_booking_be.service;

import org.springframework.stereotype.Service;
import vnpt.movie_booking_be.dto.request.UserCreationRequest;
import vnpt.movie_booking_be.models.User;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User createUser(UserCreationRequest request) {
        User user = new User();

        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());


        return null;
    }
}
