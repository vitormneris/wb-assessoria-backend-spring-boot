package com.br.wb.service;

import com.br.wb.domain.Administrator;
import com.br.wb.domain.Client;
import com.br.wb.enums.Values;
import com.br.wb.respositories.AdministratorRepository;
import com.br.wb.respositories.ClientRepository;
import com.br.wb.service.exceptions.DuplicateRecordException;
import com.br.wb.service.exceptions.InvalidFormatException;
import com.br.wb.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdministratorService {
    private final AdministratorRepository repository;
    private final CheckFiedService checkFiedService;
    private final PasswordEncoder encoder;

    public List<Administrator> findAll() {
        return repository.findAll();
    }

    public Administrator findById(String id) {
        try {
            Optional<Administrator> obj = repository.findById(id);
            return obj.orElseThrow();
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Id", id);
        }
    }

    public Administrator findByEmail(String email) {
        try {
            Optional<Administrator> obj = repository.findByEmail(email);
            return obj.orElseThrow();
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("E-mal", email);
        }
    }

    @Transactional
    public Administrator insert(Administrator administrator) {
        try {
            administrator.setId(null);
            checkFiedService.checkFieldsAdministrator(administrator);

            if (repository.findByEmail(administrator.getEmail()).isPresent())
                throw new DuplicateRecordException("The e-mail is already registered");

            administrator.setRole(Values.ADMIN);
            administrator.setPassword(encoder.encode(administrator.getPassword()));
            return repository.save(administrator);
        } catch (InvalidFormatException e){
            throw new InvalidFormatException(e.getMessage());
        } catch (DuplicateRecordException e) {
            throw new DuplicateRecordException(e.getMessage());
        }
    }

    @Transactional
    public Administrator update(String id, Administrator administrator) {
        try {
            Optional<Administrator> obj = repository.findById(id);
            updateData(obj.orElseThrow(), administrator);
            obj.get().setId(id);

            checkFiedService.checkFieldsAdministrator(obj.get());

            return repository.save(obj.get());
        } catch (InvalidFormatException e){
            throw new InvalidFormatException(e.getMessage());
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Id", id);
        }
    }

    @Transactional
    public void delete(String id) {
        try {
            Optional<Administrator> objAdministrator = repository.findById(id);
            repository.delete(objAdministrator.orElseThrow());
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Id", id);
        }
    }

    private void updateData(Administrator obj, Administrator administrator) {
        obj.setName((administrator.getName() == null) ? obj.getName() : administrator.getName());
        obj.setEmail((administrator.getEmail() == null) ? obj.getEmail() : administrator.getEmail());
    }
}
