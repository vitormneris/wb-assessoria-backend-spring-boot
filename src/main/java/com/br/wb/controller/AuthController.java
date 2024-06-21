package com.br.wb.controller;

import com.br.wb.domain.Client;
import com.br.wb.dto.LoginDTO;
import com.br.wb.service.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
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
@Tag(name = "autenticação")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;


    @Operation(summary = "Faz autenticação do usuário através do login ", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Logado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse(responseCode = "422", description = "Dados da requisição inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro de servidor"),
    })
    @PostMapping(value = "/authenticate", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String authenticate(@RequestBody LoginDTO loginDTO) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginDTO.email(), loginDTO.password());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        var user = (Client) authenticate.getPrincipal();
        return tokenService.tokenGeneration(user);
    }

    @Operation(summary = "Obtem a rota protegida", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aceito com sucesso"),
            @ApiResponse(responseCode = "400", description = "Parâmetros inválidos"),
            @ApiResponse(responseCode = "422", description = "Dados da requisição inválidos"),
            @ApiResponse(responseCode = "500", description = "Erro de servidor"),
    })
    @GetMapping("/protected")
    public ResponseEntity<String> getProtectedResource() {
        return ResponseEntity.ok("Allowed");
    }
}
