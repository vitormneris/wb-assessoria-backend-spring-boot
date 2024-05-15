package com.br.wb.domain.proceeding;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Proceeding {
    private Source numeroDoProcesso;
    private String dataHoraUltimaAtualizacao;
    private List<Movement> movements;
}
