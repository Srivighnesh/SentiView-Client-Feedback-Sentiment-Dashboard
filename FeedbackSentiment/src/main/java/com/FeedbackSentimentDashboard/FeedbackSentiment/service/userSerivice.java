package com.FeedbackSentimentDashboard.FeedbackSentiment.service;


import com.FeedbackSentimentDashboard.FeedbackSentiment.entity.Users;
import com.FeedbackSentimentDashboard.FeedbackSentiment.repo.UsersRepo;
import com.FeedbackSentimentDashboard.FeedbackSentiment.requests.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class userSerivice {

    @Autowired
    UsersRepo usersRepo;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    // REGISTER USER (hash password)
    public Users addUser(Users users) {
        // Encrypt the password
        String encodedPassword = passwordEncoder.encode(users.getPassword());
        users.setPassword(encodedPassword);

        return usersRepo.save(users);
    }

    // LOGIN CHECK
    public Boolean loginUser(LoginRequest loginRequest) {

        Optional<Users> user = usersRepo.findByEmail(loginRequest.getEmail());

        if (user.isEmpty()) {
            return false;
        }

        Users user1 = user.get();

        // Check raw password with encrypted password
        return passwordEncoder.matches(loginRequest.getPassword(), user1.getPassword());
    }

}
