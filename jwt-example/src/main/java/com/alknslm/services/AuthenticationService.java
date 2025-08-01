package com.alknslm.services;

import com.alknslm.dtos.AuthenticationResponse;
import com.alknslm.dtos.LoginUserDto;
import com.alknslm.dtos.RegisterUserDto;
import com.alknslm.entities.User;
import com.alknslm.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthenticationService(
            UserRepository userRepository,
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public AuthenticationResponse signup(RegisterUserDto input) {
        User user = new User();
        user.setFullName(input.getFullName());
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setRole(input.getRole());

        user = userRepository.save(user);
        String token = jwtService.generateToken(user);


        return new AuthenticationResponse(token);
//        return userRepository.save(user);
    }

    public AuthenticationResponse authenticate(LoginUserDto input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );

        User user = userRepository.findByEmail(input.getEmail()).orElseThrow();
        String token = jwtService.generateToken(user);

        return new AuthenticationResponse(token);
//        return userRepository.findByEmail(input.getEmail()).orElseThrow();
    }
}
