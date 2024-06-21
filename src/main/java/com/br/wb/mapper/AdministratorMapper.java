package com.br.wb.mapper;

import com.br.wb.domain.Address;
import com.br.wb.domain.Administrator;
import com.br.wb.domain.Client;
import com.br.wb.dto.AdministratorDTO;
import com.br.wb.dto.ClientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdministratorMapper {
    public Administrator mapToModel(AdministratorDTO dto) {
        return new Administrator(
                dto.id(),
                dto.name(),
                dto.email(),
                dto.password()
        );
    }
}
