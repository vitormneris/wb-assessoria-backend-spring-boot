package com.br.wb.controller;

import java.util.List;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.wb.dto.UserDTO;
import com.br.wb.mapper.UserMapper;
import com.br.wb.domain.User;
import com.br.wb.service.UserService;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public ResponseEntity<User> salvar(@RequestBody UserDTO userDTO) {
        User model = userMapper.mapToModel(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.salvar(model));
    }

    @GetMapping
    public ResponseEntity<List<User>> listar() {
        return ResponseEntity.ok().body(userService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> buscar(@PathVariable String id) throws BadRequestException {
        return ResponseEntity.ok().body(userService.buscar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> atualizar(@PathVariable String id,
                                          @RequestBody UserDTO userDTO) throws Exception {
        User model = userMapper.mapToModel(userDTO);
        return ResponseEntity.ok().body(userService.atualizar(id, model));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        userService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}


