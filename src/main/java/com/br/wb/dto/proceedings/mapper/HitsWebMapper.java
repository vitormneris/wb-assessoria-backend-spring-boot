package com.br.wb.dto.proceedings.mapper;

import com.br.wb.domain.proceeding.Movement;
import com.br.wb.domain.proceeding.Proceeding;
import com.br.wb.dto.proceedings.HitsDTO;
import com.br.wb.dto.proceedings.MovementsDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HitsWebMapper {


    default Proceeding mapToProceeding(HitsDTO dto) {
        return Proceeding.builder()
                .numeroDoProcesso(null)
                .dataHoraUltimaAtualizacao(dto.getDataHoraUltimaAtualizacao())
                .movements(dto.get_sourceDTO().movimentos().stream().map(this::mapToProceeding).toList())
                .build();
    }
    default Movement mapToProceeding(MovementsDTO dto) {
        return Movement.builder()
                .nome(dto.getNome())
                .complementosTabelados(null)
                .codigo(dto.getCodigo())
                .dataHora(dto.getDataHora())
                .build();
    }


}
