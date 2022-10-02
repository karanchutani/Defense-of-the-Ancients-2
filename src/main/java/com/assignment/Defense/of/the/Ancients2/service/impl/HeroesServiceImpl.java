package com.assignment.Defense.of.the.Ancients2.service.impl;

import com.assignment.Defense.of.the.Ancients2.exception.ServiceLevelException;
import com.assignment.Defense.of.the.Ancients2.service.HeroesService;
import com.assignment.Defense.of.the.Ancients2.util.BasicValidations;
import com.assignment.Defense.of.the.Ancients2.util.Constant;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * This is HeroesServiceImpl class for implementation scenarios.
 * @author karan
 */
@Service
public class HeroesServiceImpl implements HeroesService {

    /**
     * restTemplate field.
     */

    @Autowired
    private RestTemplate restTemplate;

    /**
     * objectMapper field.
     */
    final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * logger field.
     */
    private Logger logger = LogManager.getLogger("HeroesServiceImpl.class");

    /**
     * baseUrl field from application.properties file.
     */
    @Value("${baseURL}")
    private String baseUrl;

    /**
     * This is findHeroesByAccount method that finding heroes by account id.
     * @param accountId field.
     * @return list of object nodes
     */
    @Override
    public ArrayNode findHeroesByAccount(Integer accountId) throws JsonProcessingException {
        BasicValidations.validateAccountId(accountId);
        final String apiUrl = baseUrl + Constant.API_PLAYERS_URL + accountId + Constant.HEROES_URL+"?is_radiant=1";
        final String response = callService(apiUrl, HttpMethod.GET);
        final JsonNode respNodes = objectMapper.readTree(response);
        ArrayNode respArrayNode = objectMapper.createArrayNode();
        int i = 0;
        for (JsonNode innerNode : respNodes) {
        respArrayNode.add(innerNode);
        i++;
        if(i==3)
            break;
        }
        return respArrayNode;
    }

    /**
     * This is findHeroesInfoById() method for finding internal information of heroes.
     * @param heroIds field.
     * @return array node
     * @throws JsonProcessingException exception.
     */
    @Override
    public ArrayNode findHeroesInfoById(List<Integer> heroIds) throws JsonProcessingException {
        BasicValidations.validateHeroIds(heroIds);
        final String apiUrl = baseUrl + Constant.API_URL + Constant.HERO_URL;
        final String response = callService(apiUrl, HttpMethod.GET);
        JsonNode respNodes = objectMapper.readTree(response);
        final ArrayNode respArrayNode = objectMapper.createArrayNode();
        for (Integer heroId: heroIds
             ) {
            for (JsonNode innerRespNode : respNodes
                    ) {
                if(innerRespNode.get("id").asInt()==heroId){
                    respArrayNode.add(createNewNode(innerRespNode));
                    break;
                }
            }
        }
        return respArrayNode;
    }

    /**
     * This is createNewNode() method for creating temperory nodes.
     * @param innerRespNode field.
     * @return json node.
     */
    private JsonNode createNewNode(JsonNode innerRespNode) {
        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put(Constant.HERO_ID, innerRespNode.get(Constant.ID));
        objectNode.put(Constant.NAME, innerRespNode.get(Constant.NAME));
        objectNode.put(Constant.LOCALIZED_MSG, innerRespNode.get(Constant.LOCALIZED_MSG));
        return objectNode;
    }

    /**
     * This is callService() method for calling rest services.
     * @param apiUrl field.
     * @param httpMethod field.
     * @return string response.
     */
    private String callService(String apiUrl, HttpMethod httpMethod) {

        ResponseEntity<String> response = null;
        try {
            final HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            response = restTemplate
                    .exchange(apiUrl,
                            httpMethod,
                            new HttpEntity<String>("{}", headers), String.class);
            return response.getBody();
        }
        catch (Exception e){
            logger.info("GETTING EXCEPTION");
            logger.error(e);
            throw new ServiceLevelException(e);
        }
    }
}
