package com.br.wb.service;

import com.br.wb.domain.Administrator;
import com.br.wb.domain.Client;
import com.br.wb.respositories.AdministratorRepository;
import com.br.wb.respositories.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
    private final ClientRepository clientRepository;
    private final AdministratorRepository administratorepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Client> objClient = clientRepository.findByEmail(username);
        if (objClient.isPresent()) {
            return objClient.get();
        }
        return administratorepository.findByEmail(username).orElseThrow();
    }
}
