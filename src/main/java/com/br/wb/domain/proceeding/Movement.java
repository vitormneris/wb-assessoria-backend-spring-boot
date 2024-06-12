package com.br.wb.domain.proceeding;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Movement {

    private List<ComplementoTabelado> complementosTabelados = new ArrayList<>();
    private int codigo;
    private String nome;
    private String dataHora;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ComplementoTabelado {
        private int codigo;
        private int valor;
        private String nome;
        private String descricao;

    }
}