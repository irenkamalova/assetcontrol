package com.kamalova.assetcontrol.api.controller;

import com.kamalova.assetcontrol.api.model.request.ReservationRequest;
import com.kamalova.assetcontrol.dao.model.ReservationDao;
import com.kamalova.assetcontrol.service.ReservationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(name = "assetcontrol", path = "/service")
@Api(value = "School Bus reservation system")
public class ReservationControllerImp extends AssetControlController
        implements ReservationController {
    @Autowired
    ReservationService reservationService;

    @Override
    public List<ReservationDao> getReservationByDate(String routeName, String date) {
        return reservationService.getReservationByDate(routeName, date);
    }

    @Override
    public ReservationDao getReservationById(String routeName, String date, String reservationId) {
        return reservationService.getReservationById(routeName, date, reservationId);
    }

    @Override
    public String createReservation(String routeName, String date, ReservationRequest reservationRequest) {
        return reservationService.createReservation(routeName, date, reservationRequest);
    }

    @Override
    public ResponseEntity<Object> updateReservation(String routeName, String date, String reservationId,
                                                    ReservationRequest reservationRequest) {
        reservationService.updateReservation(routeName, date, reservationId, reservationRequest);
        return ResponseEntity.ok("Successfully updated");
    }

    @Override
    public ResponseEntity<Object> deleteReservation(String routeName, String date, String reservationId) {
        reservationService.deleteReservation(routeName, date, reservationId);
        return ResponseEntity.ok("Successfully deleted");
    }
}
