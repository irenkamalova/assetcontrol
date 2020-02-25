package com.kamalova.assetcontrol.api.controller;

import com.kamalova.assetcontrol.api.model.request.ReservationRequest;
import com.kamalova.assetcontrol.dao.model.ReservationDao;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ReservationController {

    @ApiOperation(value = "Get reservations by date", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Invalid argument"),
    })
    @GetMapping(value = "/reservations/{route_name}/{date}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    List<ReservationDao> getReservationByDate(@PathVariable(name = "route_name") String routeName,
                                              @PathVariable(name = "date") String date);

    @ApiOperation(value = "Get reservation by id", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Invalid argument"),
    })
    @GetMapping(value = "/reservations/{route_name}/{date}/{reservation_id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    ReservationDao getReservationById(@PathVariable(name = "route_name") String routeName,
                                      @PathVariable(name = "date") String date,
                                      @PathVariable(name = "reservation_id") String reservationId);

    @ApiOperation(value = "Create reservation", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Invalid argument"),
    })
    @PostMapping(value = "/reservations/{route_name}/{date}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = {MediaType.TEXT_PLAIN_VALUE, MediaType.APPLICATION_JSON_VALUE})
    String createReservation(@PathVariable(name = "route_name") String routeName,
                             @PathVariable(name = "date") String date,
                             @RequestBody ReservationRequest reservationRequest);


    @ApiOperation(value = "Update reservation by id", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Invalid argument"),
    })
    @PutMapping(value = "/reservations/{route_name}/{date}/{reservation_id}")
    ResponseEntity<Object> updateReservation(@PathVariable(name = "route_name") String routeName,
                                             @PathVariable(name = "date") String date,
                                             @PathVariable(name = "reservation_id") String reservationId,
                                             @RequestBody ReservationRequest reservationRequest);

    @ApiOperation(value = "Delete reservation by id", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Invalid argument"),
    })
    @DeleteMapping(value = "/reservations/{route_name}/{date}/{reservation_id}")
    ResponseEntity<Object> deleteReservation(@PathVariable(name = "route_name") String routeName,
                                             @PathVariable(name = "date") String date,
                                             @PathVariable(name = "reservation_id") String reservationId);

}
