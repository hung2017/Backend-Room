package com.example.pokemon_teddy.dto;

import lombok.Data;

@Data
public class AuthReponDto {
    private String accessToken;
    private String tokenType = "Bearer ";

    public AuthReponDto(String accessToken) {
        this.accessToken = accessToken;
    }
}
