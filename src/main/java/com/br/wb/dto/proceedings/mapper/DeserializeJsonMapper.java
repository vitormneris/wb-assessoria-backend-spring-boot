package com.br.wb.dto.proceedings.mapper;

import com.br.wb.dto.proceedings.HitsDTO;
import com.br.wb.dto.proceedings.SourceDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeserializeJsonMapper {
    public List<HitsDTO> deserializeToObject(JsonNode jsonNode) throws JsonProcessingException {
        List<HitsDTO> hitsDTO = new ArrayList<>();
        if (jsonNode != null && jsonNode.hasNonNull("hits")) {
            JsonNode hitsNode = jsonNode.get("hits").get("hits");
            for (JsonNode node : hitsNode) {
                JsonNode sourceNode = node.get("_source");
                ObjectMapper objectMapper = new ObjectMapper();
                SourceDTO sourceDTO = objectMapper.treeToValue(sourceNode, SourceDTO.class);
                HitsDTO hit = new HitsDTO();
                hit.set_sourceDTO(sourceDTO);
                hitsDTO.add(hit);
            }
        }
        return hitsDTO;
    }
}



