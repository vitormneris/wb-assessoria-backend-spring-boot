package com.br.wb.controller;

import com.br.wb.dto.proceedings.HitsDTO;
import com.br.wb.service.ProceedingsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/processos")
public class ProceedingsController {
    private final ProceedingsService proceedingsService;

    @PostMapping
    public List<HitsDTO> BuscarPorNumero(@RequestBody String numeroProcesso) throws IOException {
        return proceedingsService.procurarPorNumero(numeroProcesso);
    }

}
