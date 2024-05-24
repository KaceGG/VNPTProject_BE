package vnpt.movie_booking_be.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vnpt.movie_booking_be.dto.request.AuthRequest;
import vnpt.movie_booking_be.dto.response.JwtResponse;
import vnpt.movie_booking_be.jwt.JwtService;
import vnpt.movie_booking_be.mapper.UserMapper;
import vnpt.movie_booking_be.models.User;
import vnpt.movie_booking_be.repository.UserRepository;

@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserMapper userMapper;


    @PostMapping("/userLogin")
    public JwtResponse AuthenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        System.out.println("abc");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));

        System.out.println("dsh");
        if (authentication.isAuthenticated()) {
            System.out.println("xyz");
            User user = userRepository.findByEmail(authRequest.getEmail());
            String token = jwtService.GenerateToken(authRequest.getEmail());
            return new JwtResponse(token , userMapper.userToUserResponse(user));
        } else {
            return new JwtResponse("",null);
        }
    }
}
