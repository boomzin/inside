package com.example.inside.web;

import com.example.inside.dto.AuthenticationRequestDto;
import com.example.inside.model.Sender;
import com.example.inside.repository.SenderRepository;
import com.example.inside.security.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = AuthenticationController.REST_URL)
public class AuthenticationController {
    static final String REST_URL = "/api/login";

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final SenderRepository senderRepository;

    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, SenderRepository senderRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.senderRepository = senderRepository;
    }

    @ResponseBody
    @PostMapping()
    public ResponseEntity login(@RequestBody AuthenticationRequestDto requestDto) {
        try {
            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            Sender sender = senderRepository
                    .findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("User with username: " + username + " not found"));


            String token = jwtTokenProvider.createToken(username);

            Map<Object, Object> response = new HashMap<>();
            response.put("username", username);
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}
