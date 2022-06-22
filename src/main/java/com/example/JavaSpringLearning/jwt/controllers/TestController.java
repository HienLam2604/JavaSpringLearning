package com.example.JavaSpringLearning.jwt.controllers;

import com.example.JavaSpringLearning.jwt.models.AuthenticationResponse;
import com.example.JavaSpringLearning.jwt.models.UserModel;
import com.example.JavaSpringLearning.jwt.repository.UserRepository;
import com.example.JavaSpringLearning.jwt.services.UserDetailsImpl;
import com.example.JavaSpringLearning.jwt.services.UserDetailsServiceImpl;
import com.example.JavaSpringLearning.jwt.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins ="http://localhost:4200")
public class TestController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserDetailsServiceImpl myUserDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping("/public")
    public String publicSite(){
        return "Public site!";
    }
    @GetMapping("/user")
    public String userSite(){
        return "USER!";
    }
    @GetMapping("/admin")
    public String adminSite(){
        return "ADMIN";
    }


    @RequestMapping(value = "/auth",method = RequestMethod.POST)
    public ResponseEntity<?> authenticateUser(@RequestBody UserModel loginRequest) throws Exception{
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword())
            );
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password !");
        }

        /*
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        //UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

         */

        UserDetails userDetails = myUserDetailsService.loadUserByUsername(loginRequest.getUsername());
        String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt)); // return jwt

    }
}
