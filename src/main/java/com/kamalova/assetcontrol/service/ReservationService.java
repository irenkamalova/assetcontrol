package com.kamalova.assetcontrol.service;

import com.kamalova.assetcontrol.api.model.request.ReservationRequest;
import com.kamalova.assetcontrol.dao.model.ReservationDao;

import java.util.List;

public interface ReservationService {

    List<ReservationDao> getReservationByDate(String routeName, String date);

    ReservationDao getReservationById(String routeName, String date, String reservationId);

    String createReservation(String routeName, String date, ReservationRequest reservationRequest);

    void updateReservation(String routeName, String date, String reservationId, ReservationRequest reservationRequest);

    void deleteReservation(String routeName, String date, String reservationId);
}

