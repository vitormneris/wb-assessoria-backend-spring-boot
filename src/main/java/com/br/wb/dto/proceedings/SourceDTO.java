package com.br.wb.dto.proceedings;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public record Source(String numeroProcesso,
              ProceedingClass proceedingClass,
              System system,
              Format format,
              String tribunal,
              String dataHora) {
}