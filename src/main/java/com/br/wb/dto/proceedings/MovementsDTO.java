package com.br.wb.dto.proceedings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movements {
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
