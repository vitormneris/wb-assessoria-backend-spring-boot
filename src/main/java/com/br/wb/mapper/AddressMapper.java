package com.br.wb.mapper;

import com.br.wb.domain.Address;
import com.br.wb.dto.AddressDTO;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {
    public Address mapToModel(AddressDTO dto) {
        return new Address(
                dto.state(),
                dto.city(),
                dto.neighborhood(),
                dto.street(),
                dto.postalCode(),
                dto.number());
    }
}
