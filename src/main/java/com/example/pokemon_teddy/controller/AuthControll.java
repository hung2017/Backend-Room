package com.example.pokemon_teddy.controller;

import com.example.pokemon_teddy.dto.AuthReponDto;
import com.example.pokemon_teddy.dto.LoginDto;
import com.example.pokemon_teddy.dto.RegisterDto;
import com.example.pokemon_teddy.model.Role;
import com.example.pokemon_teddy.model.UserEntity;
import com.example.pokemon_teddy.reponsitory.RoleRepo;
import com.example.pokemon_teddy.reponsitory.UserRepo;
import com.example.pokemon_teddy.security.JWTGenerate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
@RestController
@RequestMapping("/api/auth")
public class AuthControll {
    private AuthenticationManager authenticationManager;
    private UserRepo userRepo;
    private RoleRepo roleRepo;
    private PasswordEncoder passwordEncoder;
    private JWTGenerate jwtGenerate;

    @Autowired
    public AuthControll(AuthenticationManager authenticationManager, UserRepo userRepo,
                        RoleRepo roleRepo, PasswordEncoder passwordEncoder, JWTGenerate jwtGenerate) {
        this.authenticationManager = authenticationManager;
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerate = jwtGenerate;
    }

    @PostMapping("login")
    public ResponseEntity<AuthReponDto> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getUsername(),
                        loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerate.generateToken(authentication);
        return new ResponseEntity<>(new AuthReponDto(token), HttpStatus.OK);
    }

    @PostMapping("register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        if (userRepo.existsByUsername(registerDto.getUsername())) {
            return new ResponseEntity<>("Username is taken!", HttpStatus.BAD_REQUEST);
        }

        UserEntity user = new UserEntity();
        user.setUsername(registerDto.getUsername());
        user.setPassword(passwordEncoder.encode((registerDto.getPassword())));

        Role roles = roleRepo.findByName("USER").get();
        user.setRoles(Collections.singletonList(roles));

        //userRepo.save(user);

        return new ResponseEntity<>("User registered success!", HttpStatus.OK);
    }
}
