package com.ict.user03.jwt;

public class JwtResponse {
    private final String token;

    public JwtResponse(String token){
        this.token = token;

    }

    public String getToken(){
        return token;
    }
}
