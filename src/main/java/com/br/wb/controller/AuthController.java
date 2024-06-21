package com.br.wb.controller;

import com.br.wb.domain.Client;
import com.br.wb.domain.inheritance.User;
import com.br.wb.dto.LoginDTO;
import com.br.wb.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
            new UsernamePasswordAuthenticationToken(loginDTO.email(), loginDTO.password());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        var user = (User) authenticate.getPrincipal();
        return tokenService.tokenGeneration(user);
    }

    @GetMapping("/client/protected")
    public ResponseEntity<String> getProtectedResourceClient() {
        return ResponseEntity.ok("Allowed client");
    }

    @GetMapping("/administrator/protected")
    public ResponseEntity<String> getProtectedResourceAdiministrator() {
        return ResponseEntity.ok("Allowed administrator");
    }
}
