package com.cabapp.pro.controller;

import com.cabapp.pro.dto.LoginDto;
import com.cabapp.pro.jwt.JwtResponse;
import com.cabapp.pro.jwt.JwtTokenUtil;
import com.cabapp.pro.jwt.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("jwt")

public class JwtController
{


    @Autowired
    private MyUserDetailService userService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AuthenticationManager authenticationManager;


    /**
     * Handles authentication for a user and generates a JWT token upon successful authentication.
     * 
     * @param user The LoginDto object containing username and password for authentication
     * @return ResponseEntity containing a JWT token in the response body upon successful authentication
     * @throws Exception Thrown when there's an issue with authentication (e.g., incorrect password)
     */

    @PostMapping("/authenticate")
    public LoginDto authenticateToken(@RequestBody LoginDto user) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getUsername(),user.getPassword()));
        }
        catch(BadCredentialsException e) {
            throw new Exception("Incorrect password");
        }
           System.out.println("inside the tryblock..............");
        final UserDetails userDetails = userService.loadUserByUsername(user.getUsername());
        String role=userDetails.getAuthorities().toString();
        
        
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        
        boolean isValid = jwt!=null?true:false;
        user.setToken(jwt);
        user.setValid(isValid);
        user.setRole(role);
        return user;
    }
    
    

}
