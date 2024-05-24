package vnpt.movie_booking_be.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vnpt.movie_booking_be.dto.request.UserCreationRequest;
import vnpt.movie_booking_be.dto.response.UserResponse;
import vnpt.movie_booking_be.mapper.UserMapper;
import vnpt.movie_booking_be.models.Membership;
import vnpt.movie_booking_be.models.Role;
import vnpt.movie_booking_be.models.User;
import vnpt.movie_booking_be.repository.MembershipRepository;
import vnpt.movie_booking_be.repository.RoleRepository;
import vnpt.movie_booking_be.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MembershipRepository membershipRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;


    @Override
    public void createUser(UserCreationRequest request) {
        Membership membership = membershipRepository.findByName("Đồng");

        Role userRole = roleRepository.findByName("USER");
        System.out.println(userRole);

        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setMembership(membership);
        user.setRoles(Collections.singleton(userRole));

        userRepository.save(user);
    }

    @Override
    public void updateUser(int userid, UserCreationRequest request) {
        User user = getUser(userid);
        userMapper.updateUser(user,request);
        userRepository.save(user);
    }

    @Override
    public User getUser(int userid) {
        return userRepository.findById(userid).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> userMapper.userToUserResponse(user))
                .collect(Collectors.toList());
    }
}
