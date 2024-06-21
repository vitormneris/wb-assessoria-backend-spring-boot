package com.br.wb.service;

import com.br.wb.domain.Address;
import com.br.wb.domain.Administrator;
import com.br.wb.domain.Client;
import com.br.wb.service.exceptions.InvalidCpfException;
import com.br.wb.service.exceptions.InvalidFormatException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CheckFiedService {


    public void checkFieldsAdministrator(Administrator administrator) throws InvalidFormatException {
        if (administrator == null) throw new InvalidFormatException("The fields can not be null.");

        isNullOrBlank(administrator.getName());
        if (!administrator.getName().matches("^[a-zA-Z ]+$"))
            throw new InvalidFormatException("Name", administrator.getName());

        isNullOrBlank(administrator.getEmail());
        if (!administrator.getEmail().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$"))
            throw new InvalidFormatException("E-mail", administrator.getEmail());

        isNullOrBlank(administrator.getPassword());
        if (!(administrator.getPassword().length() >= 8))
            throw new InvalidFormatException("Format is not valid. Password");
    }

    public void checkFieldsClient(Client client) throws InvalidFormatException {
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

        isNullOrBlank(client.getCountry());
        if (!client.getCountry().matches("^[a-zA-Z ]+$"))
            throw new InvalidFormatException("Country", client.getCountry());

        isNullOrBlank(client.getPhones());
        int cont = 0;
        for (String phone :client.getPhones()) {
            if (!phone.matches("\\(?\\d{2}\\)? ?(?:\\d{4,5}-?\\d{4}|\\d{4}-?\\d{4})$"))
                throw new InvalidFormatException("Phone", client.getPhones().get(cont));
            cont++;
        }

        isNullOrBlank(client.getPassword());
        if (!(client.getPassword().length() >= 8))
            throw new InvalidFormatException("Format is not valid. Password");
    }

    public void checkFieldsAddress(Address address) throws InvalidFormatException {
        if (address == null) throw new InvalidFormatException("The fields can not be null.");

        isNullOrBlank(address.getState());
        if (!address.getState().matches("^[a-zA-Z ]+$"))
            throw new InvalidFormatException("State", address.getState());

        isNullOrBlank(address.getCity());
        isNullOrBlank(address.getNeighborhood());

        isNullOrBlank(address.getPostalCode());
        if (!address.getPostalCode().matches("^[0-9]{5}-[0-9]{3}$"))
            throw new InvalidFormatException("Postal Code", address.getPostalCode());

        isNullOrBlank(address.getStreet());
        isNullOrBlank(address.getNumber());
    }

    public void checkFieldsRNM(Client.RNMDocument rnm) throws InvalidFormatException {
        if (rnm == null) throw new InvalidFormatException("The fields can not be null.");

        isNullOrBlank(rnm.getClassification());
        isNullOrBlank(rnm.getDateOfIssue());
        isNullOrBlank(rnm.getNumber());
    }

    private void isNullOrBlank(String string) throws InvalidFormatException {
        if (string == null || string.isBlank())
            throw new InvalidFormatException("The fields can not be null.");
    }

    private void isNullOrBlank(Integer integer) throws InvalidFormatException {
        if (integer == null)
            throw new InvalidFormatException("The fields can not be null.");
    }

    private void isNullOrBlank(List<String> list) throws InvalidFormatException {
        if (list == null)
            throw new InvalidFormatException("The fields can not be null.");
    }

    public void cpfIsValid(String cpf) throws InvalidCpfException {
        List<String> cpfList = new ArrayList<>(Arrays.asList(cpf.split("")));

        for (int i = 0; i < 11 ; i++)
            if (cpfList.get(i).equals(".") || cpfList.get(i).equals("-"))
                cpfList.remove(i);

        int sum = 0;
        for (int i = 1; i < 10; i++)
            sum += (Integer.parseInt(cpfList.get(i - 1)) * i);

        int rest = sum % 11;
        if (rest == 10) rest = 0;
        int firstDigit = rest;

        sum = 0;
        for (int i = 0; i < 10; i++)
            sum += (Integer.parseInt(cpfList.get(i)) * i);

        rest = sum % 11;
        if (rest == 10) rest = 0;
        int secondtDigit = rest;

        if (!(cpfList.get(9).equals(Integer.toString(firstDigit)) && cpfList.get(10).equals(Integer.toString(secondtDigit))))
            throw new InvalidCpfException();
    }
}
