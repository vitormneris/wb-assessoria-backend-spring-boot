package com.br.wb.service;

import com.br.wb.domain.LastProcessMovement;
import com.br.wb.dto.proceedings.mapper.DeserializeJsonMapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

@Service
@RequiredArgsConstructor
public class DataJudConnectionService {

    private final DeserializeJsonMapper deserializeJsonMapper;


    @Value("${api.url}")
    String url;

    @Value("${api.token}")
    String token;

    public List<LastProcessMovement> procurarPorNumero(String numeroProcesso) throws IOException {


        Map<String, Object> query = new HashMap<>();
        Map<String, Object> match = new HashMap<>();
        match.put("numeroProcesso", numeroProcesso);
        query.put("match", match);
        Map<String, Object> payload = new HashMap<>();
        payload.put("query", query);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", token);

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper objectMapper = new ObjectMapper();

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(payload, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        JsonNode jsonNode = objectMapper.readTree(response.getBody());
        return deserializeJsonMapper.deserializeToObject(jsonNode);
    }
}
