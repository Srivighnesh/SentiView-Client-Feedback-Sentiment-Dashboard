package com.FeedbackSentimentDashboard.FeedbackSentiment.Controller;

import com.FeedbackSentimentDashboard.FeedbackSentiment.entity.Users;
import com.FeedbackSentimentDashboard.FeedbackSentiment.requests.LoginRequest;
import com.FeedbackSentimentDashboard.FeedbackSentiment.service.userSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class usersController {

    @Autowired
    userSerivice userSerivice;

    @PostMapping("/register")
    public Users addUser(@RequestBody Users user) {
        return userSerivice.addUser(user);
    }
    @PostMapping("/login")
    public Boolean loginUser(@RequestBody LoginRequest loginRequest) {
        return userSerivice.loginUser(loginRequest);
    }
}
