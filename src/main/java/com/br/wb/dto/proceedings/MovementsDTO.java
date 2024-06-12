package com.br.wb.dto.proceedings;

import lombok.*;

import java.util.List;

@Builder
public record MovementsDTO(
        List<ComplementoTabeladoDTO> complementosTabelados,
        int codigo,
        String nome,
        @Getter
        String dataHora) {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ComplementoTabeladoDTO {
        private int codigo;
        private int valor;
        private String nome;
        private String descricao;
    }
}
