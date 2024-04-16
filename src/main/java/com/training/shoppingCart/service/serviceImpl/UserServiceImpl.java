package com.training.shoppingCart.service.serviceImpl;

import com.training.shoppingCart.repository.UserRepo;
import com.training.shoppingCart.requestWrapper.UserRequestWrapper;
import com.training.shoppingCart.service.UserService;
import com.training.shoppingCart.model.User;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepo userRepository;
    @Override
    public String login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // Generate and return JWT token here
            return generateToken(username);
        }
        return null; // or throw an exception indicating login failure
    }

    @Override
    public void adduser(UserRequestWrapper request) {
          User user = new User();
          user.setUsername(request.getUsername());
          user.setEmail(request.getEmail());
          user.setPassword(request.getPassword());
          user.setRoles(request.getRoles());

          userRepository.save(user);
    }


    private String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .signWith(SignatureAlgorithm.HS512, "yourSecretKey") // Use a strong secret key here
                .compact();
    }


}
