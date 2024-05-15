package com.br.wb.dto.proceedings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public record SourceDTO(String numeroProcesso,
                        String tribunal,
                        List<MovementsDTO> movimentos,
                        String dataHora) {
}