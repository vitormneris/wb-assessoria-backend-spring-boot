package com.br.wb.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.br.wb.domain.Client;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String tokenGeneration(Client client) {
        return JWT.create()
                .withSubject(client.getUsername())
                .withClaim("id", client.getId())
                .withExpiresAt(LocalDateTime.now().plusMinutes(10).toInstant(ZoneOffset.of("-03:00")))
                .sign(Algorithm.HMAC256("AKSJNDSA790KJBASB89HASHF"));
    }

    public String getSubject(String token) {
        String jwt = token.replace("Bearer1 ", "");
        return JWT.require(Algorithm.HMAC256("AKSJNDSA790KJBASB89HASHF"))
                .build().verify(jwt).getSubject();
    }
}
