package vnpt.movie_booking_be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vnpt.movie_booking_be.dto.request.UserCreationRequest;
import vnpt.movie_booking_be.models.User;
import vnpt.movie_booking_be.service.UserService;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/createUser")
    public User createUser(@RequestBody UserCreationRequest request) {
        return userService.createUser(request);
    }
}
