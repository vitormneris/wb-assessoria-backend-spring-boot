package com.br.wb.domain.proceeding;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Proceeding {
    private Classe classe;
    private Source numeroProcesso;
    private String tribunal;
    private List<Movement> movimentos;
    private Date dataHora;
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Classe {
        private int codigo;
        private String nome;
    }}
