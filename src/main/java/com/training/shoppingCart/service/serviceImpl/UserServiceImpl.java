package com.training.shoppingCart.service.serviceImpl;
import com.training.shoppingCart.DTO.UserDto;
import com.training.shoppingCart.model.User;
import com.training.shoppingCart.repository.UserRepo;
import com.training.shoppingCart.requestWrapper.UserRequestWrapper;
import com.training.shoppingCart.service.UserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepository;

  

    @Override
    public UserDto getUserByUsername(String username) {
        User userEntity = userRepository.findByUsername(username);
        if (userEntity != null) {
            UserDto userDTO = new UserDto();
            userDTO.setId(userEntity.getId());
            userDTO.setUsername(userEntity.getUsername());
            return userDTO;
        }
        return null;
    }

    @Override
    public String login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // Generate and return JWT token here
            return generateToken(username);
        }
        return null; // or throw an exception indicating login failure
    }

    private String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS512, "yourSecretKey") // Use a strong secret key here
                .compact();
    }

    @Override
    public User createUser(UserRequestWrapper userDTO) {
        User newUser = new User();
        newUser.setUsername(userDTO.getUsername());
        newUser.setPassword(userDTO.getPassword());

        userRepository.save(newUser);
        return newUser;
    }

    @Override
    public User updateUser(Integer userId, UserRequestWrapper userDTO) {

        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setUsername(userDTO.getUsername());
        existingUser.setPassword(userDTO.getPassword());
        User updatedUser = userRepository.save(existingUser);

        return existingUser;
    }

    @Override
    public String deleteUser(Integer userId) {
        userRepository.deleteById(userId);
        return "User data deleted";
    }









}