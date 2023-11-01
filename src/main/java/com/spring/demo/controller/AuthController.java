package com.spring.demo.controller;

import com.spring.demo.model.Login;
import com.spring.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.token.TokenService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private AuthenticationManager authManager;
    @PostMapping("/login")
    public String login(@RequestBody Login login){
        UsernamePasswordAuthenticationToken usernamePasswordAuthToken
         = new UsernamePasswordAuthenticationToken(login.email() ,
        login.password());

        Authentication authenticate = this.authManager.authenticate((usernamePasswordAuthToken));
        var user =  (User) authenticate.getPrincipal();
        return  "logged In";
    }
}
