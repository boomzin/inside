package com.example.inside.security;

import com.example.inside.model.Sender;
import com.example.inside.repository.SenderRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(JwtUserDetailsService.class);
    private final SenderRepository senderRepository;

    public JwtUserDetailsService(SenderRepository senderRepository) {
        this.senderRepository = senderRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            log.info("Authenticating '{}'", username);
            Optional<Sender> optionalSender = senderRepository.findByUsername(username.toLowerCase());
            return new JwtUser(optionalSender.orElseThrow(
                    () -> new UsernameNotFoundException("Sender '" + username + "' was not found")), new ArrayList<>());
    }
}
