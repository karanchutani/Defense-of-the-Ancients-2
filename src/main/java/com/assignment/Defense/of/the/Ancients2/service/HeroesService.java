package com.assignment.Defense.of.the.Ancients2.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.List;

public interface HeroesService {

    ArrayNode findHeroesByAccount(Integer accountId) throws JsonProcessingException;

    ArrayNode findHeroesInfoById(List<Integer> heroIds) throws JsonProcessingException;
}
