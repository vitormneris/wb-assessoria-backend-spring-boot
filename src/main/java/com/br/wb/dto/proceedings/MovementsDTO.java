package com.br.wb.dto.proceedings;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovementsDTO {
    private List<ComplementoTabelado> complementosTabelados;
    private int codigo;
    private String nome;
    private String dataHora;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static class ComplementoTabelado {
        private int codigo;
        private int valor;
        private String nome;
        private String descricao;

    }
}
