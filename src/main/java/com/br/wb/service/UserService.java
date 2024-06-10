package com.br.wb.service;

import java.util.List;
import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.wb.domain.User;
import com.br.wb.respositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    public User salvar(User usuario) {
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        return userRepository.save(usuario);
    }

    public List<User> listar() {
        return userRepository.findAll();
    }

    public User buscar(String id) throws BadRequestException {
        Optional<User> usuario = userRepository.findById(id);
        return usuario.orElseThrow(() -> new BadRequestException("Usuario não encontrado"));
    }

    public User atualizar(String id, User novoUsuario) throws Exception {
        Optional<User> usuario = userRepository.findById(id);
        if (usuario.isPresent()) {
            User usuarioAtualizado = usuario.get();
            usuarioAtualizado.setName(novoUsuario.getName());
            usuarioAtualizado.setPhoneNumber(novoUsuario.getPhoneNumber());
            usuarioAtualizado.setEmail(novoUsuario.getEmail());
            usuarioAtualizado.setPassword(novoUsuario.getPassword());
            return userRepository.save(usuarioAtualizado);
        } else throw new Exception("Usuario não encontrado");
    }

    public void deletar(String id) {
        userRepository.deleteById(id);
    }
}
