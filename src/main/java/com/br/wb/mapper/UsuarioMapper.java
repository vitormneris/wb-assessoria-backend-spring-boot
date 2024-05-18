package com.br.wb.mapper;

import org.springframework.stereotype.Component;

import com.br.wb.dto.UsuarioDTO;
import com.br.wb.model.Usuario;

@Component
public class UsuarioMapper {
    public Usuario mapToModel(UsuarioDTO dto) {
        ;
       
        return new Usuario(
                );
    }


}
