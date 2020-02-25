package com.kamalova.assetcontrol.api.controller;

import com.kamalova.assetcontrol.dao.model.RouteDao;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public interface RoutesController {

    @ApiOperation(value = "Returns the list of all the routes present in the RDBMS")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved data"),
            @ApiResponse(code = 400, message = "Invalid argument"),
    })
    @GetMapping(value = "/routes",
            produces = APPLICATION_JSON_VALUE)
    Iterable<RouteDao> getAllRoutes();

    @ApiOperation(value = "Returns a specific route including all its stops")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved data"),
            @ApiResponse(code = 400, message = "Invalid argument"),
    })
    @GetMapping(value = "/routes/{name}",
            produces = APPLICATION_JSON_VALUE)
    RouteDao getRouteByName(@PathVariable String name);
}
