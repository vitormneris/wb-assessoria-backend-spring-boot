package com.br.wb.service;

import com.br.wb.dto.proceedings.HitsDTO;
import com.br.wb.dto.proceedings.SourceDTO;
import com.br.wb.dto.proceedings.mapper.HitsWebMapper;
import com.br.wb.dto.proceedings.mapper.DeserializeJsonMapper;
import com.br.wb.respositories.ProceedingsRepository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ProceedingsService {
    private final ProceedingsRepository proceedingsRepository;
    private final DeserializeJsonMapper deserializeJsonMapper;
    private final HitsWebMapper hitsWebMapper;

    public List<HitsDTO> procurarPorNumero(String numeroProcesso) throws IOException {
        String url = "https://api-publica.datajud.cnj.jus.br/api_publica_trf1/_search";

        Map<String, Object> query = new HashMap<>();
        Map<String, Object> match = new HashMap<>();
        match.put("numeroProcesso", numeroProcesso);
        query.put("match", match);
        Map<String, Object> payload = new HashMap<>();
        payload.put("query", query);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "APIKey cDZHYzlZa0JadVREZDJCendQbXY6SkJlTzNjLV9TRENyQk1RdnFKZGRQdw==");

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(payload, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        JsonNode jsonNode = objectMapper.readTree(response.getBody());
        return deserializeJsonMapper.deserializeToObject(jsonNode);
    }
}
