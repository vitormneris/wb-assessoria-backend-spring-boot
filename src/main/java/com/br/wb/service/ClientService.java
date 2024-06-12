package com.br.wb.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import com.br.wb.domain.Client;
import com.br.wb.respositories.ClientRepository;
import com.br.wb.service.exceptions.InvalidFormatException;
import com.br.wb.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository repository;
    private final PasswordEncoder encoder;

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client findById(String id) {
        try {
            Optional<Client> obj = repository.findById(id);
            return obj.orElseThrow();
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Id", id);
        }
    }

    public Client findByCpf(String cpf) {
        try {
            Optional<Client> obj = repository.findByCpf(cpf);
            return obj.orElseThrow();
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("CPF", cpf);
        }
    }

    public Client findByEmail(String email) {
        try {
            Optional<Client> obj = repository.findByEmail(email);
            return obj.orElseThrow();
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("E-mal", email);
        }
    }

    public Client insert(Client client) {
        try {
            client.setId(null);
            checkFields(client);
            client.setPassword(encoder.encode(client.getPassword()));
            return repository.save(client);
        } catch (InvalidFormatException e){
            throw new InvalidFormatException(e.getMessage());
        }
    }

    public Client update(String id, Client client) {
        try {
            Optional<Client> obj = repository.findById(id);
            updateData(obj.orElseThrow(), client);
            obj.get().setId(id);
            checkFields(obj.get());
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
            Optional<Client> objClient = repository.findById(id);
            repository.delete(objClient.orElseThrow());
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Id", id);
        }
    }

    private void updateData(Client obj, Client client) {
        obj.setCpf((client.getCpf() == null) ? obj.getCpf() : client.getCpf());
        obj.setName((client.getName() == null) ? obj.getName() : client.getName());
        obj.setEmail((client.getEmail() == null) ? obj.getEmail() : client.getEmail());
        obj.setPhones((client.getPhones() == null) ? obj.getPhones() : client.getPhones());
    }

    private void checkFields(Client client) throws InvalidFormatException {
        if (client == null) throw new InvalidFormatException("The fields can not be null.");

        isNullOrBlank(client.getCpf());
        if (!client.getCpf().matches("^[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}$"))
            throw new InvalidFormatException("CPF", client.getCpf());

        isNullOrBlank(client.getName());
        if (!client.getName().matches("^[a-zA-Z ]+$"))
            throw new InvalidFormatException("Name", client.getName());

        isNullOrBlank(client.getEmail());
        if (!client.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))
            throw new InvalidFormatException("E-mail", client.getEmail());

        isNullOrBlank(client.getPhones());
        for (String phone : client.getPhones())
            if (!phone.matches("\\(?\\d{2}\\)? ?(?:\\d{4,5}-?\\d{4}|\\d{4}-?\\d{4})$"))
                throw new InvalidFormatException("Phone", client.getPhones());

        isNullOrBlank(client.getPassword());
        if (!(client.getPassword().length() >= 8))
            throw new InvalidFormatException("Password");
    }

    private void isNullOrBlank(String string) throws InvalidFormatException {
        if (string == null || string.isBlank())
            throw new InvalidFormatException("The fields can not be null.");
    }

    private void isNullOrBlank(List<String> list) throws InvalidFormatException {
        if (list == null)
            throw new InvalidFormatException("The fields can not be null.");
    }
}
