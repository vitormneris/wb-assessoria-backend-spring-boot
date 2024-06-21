package com.br.wb.controller;

import com.br.wb.domain.Administrator;
import com.br.wb.domain.Client;
import com.br.wb.dto.AdministratorDTO;
import com.br.wb.dto.ClientDTO;
import com.br.wb.mapper.AdministratorMapper;
import com.br.wb.mapper.ClientMapper;
import com.br.wb.service.AdministratorService;
import com.br.wb.service.ClientService;
import com.br.wb.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/administrators")
@RequiredArgsConstructor
public class AdministratorController {
    private final AdministratorService service;
    private final AdministratorMapper mapper;
    private final TokenService tokenService;

    @GetMapping
    public ResponseEntity<List<Administrator>> findAll() {
        List<Administrator> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/token")
    public ResponseEntity<Administrator> findByToken(@RequestHeader("Authorization") String token) {
        Administrator obj = service.findById(tokenService.getClaimId(token));
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Administrator> findById(@PathVariable String id) {
        Administrator obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<Administrator> findByEmail(@PathVariable String email) {
        Administrator obj = service.findByEmail(email);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Administrator> insert(@RequestBody AdministratorDTO administratorDTO) {
        Administrator administrator = mapper.mapToModel(administratorDTO);
        Administrator obj = service.insert(administrator);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Administrator> update(@PathVariable String id, @RequestBody AdministratorDTO administratorDTO) {
        Administrator client = mapper.mapToModel(administratorDTO);
        Administrator obj = service.update(id, client);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}



