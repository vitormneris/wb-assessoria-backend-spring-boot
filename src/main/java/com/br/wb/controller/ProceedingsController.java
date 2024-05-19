package com.br.wb.controller;

import com.br.wb.domain.LastProcessMovement;
import com.br.wb.dto.proceedings.LastProcessMovementDTO;
import com.br.wb.dto.proceedings.mapper.LastProcessMovementWebMapper;
import com.br.wb.service.LastProcessMovementService;
import com.br.wb.service.DataJudConnectionService;
import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/processos")
public class ProceedingsController {
    private final DataJudConnectionService dataJudConnectionService;
    private final LastProcessMovementService lastProcessMovementService;
    private final LastProcessMovementWebMapper lastProcessMovementWebMapper;

    @PostMapping
    public List<LastProcessMovement> BuscarPorNumero(@RequestBody String numeroProcesso) throws IOException {
        return dataJudConnectionService.procurarPorNumero(numeroProcesso);
    }

    @PostMapping("/ultimomovimento")
    public ResponseEntity<LastProcessMovementDTO> save(@RequestBody LastProcessMovementDTO dto) {
        var domain = lastProcessMovementWebMapper.mapToDomain(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(lastProcessMovementWebMapper.mapToDto(lastProcessMovementService.save(domain)));
    }

    @GetMapping("/most-recent")
    public Optional<LastProcessMovement> getMostRecentMovement() {
        return lastProcessMovementService.getMostRecentMovement();
    }
}
