package com.assignment.Defense.of.the.Ancients2.controller;

import com.assignment.Defense.of.the.Ancients2.service.HeroesService;
import com.assignment.Defense.of.the.Ancients2.util.Constant;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.node.ArrayNode;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This is HeroesController class for finding heroes informtion.
 * @author karan
 */
@RestController
@RequestMapping("/heroes")
public class HeroesController {

    /**
     * heroesService field.
     */
    @Autowired
    private HeroesService heroesService;

    @ApiOperation(value = "Fetch details of top three heroes with most number of games playedfrom radiant side by the player.", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = Constant.FETCH_DETAIL_SUCCESS),
            @ApiResponse(code = 403, message = Constant.FORBIDDEN),
            @ApiResponse(code = 400, message = Constant.BAD_REQUEST)
    }
    )
    @GetMapping(value = "/details",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getHeroesByAccountId(@RequestParam(value = "account_id", required = false) Integer accountId) throws JsonProcessingException {

        final ArrayNode responseList = heroesService.findHeroesByAccount(accountId);
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @ApiOperation(value = "Fetch internal information of heroes by given id.", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = Constant.FETCH_DETAIL_SUCCESS),
            @ApiResponse(code = 403, message = Constant.FORBIDDEN),
            @ApiResponse(code = 400, message = Constant.BAD_REQUEST)
    }
    )
    @GetMapping(value = "/internal-info", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getHeroesInfo(@RequestParam(value = "heroIds", required = false) List<Integer> heroIds) throws JsonProcessingException {

        final ArrayNode responseList = heroesService.findHeroesInfoById(heroIds);
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

}
