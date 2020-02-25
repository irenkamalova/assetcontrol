package com.kamalova.assetcontrol.service;

import com.kamalova.assetcontrol.api.model.request.ReservationRequest;
import com.kamalova.assetcontrol.dao.BusRepository;
import com.kamalova.assetcontrol.dao.ReservationRepository;
import com.kamalova.assetcontrol.dao.RouteRepository;
import com.kamalova.assetcontrol.dao.model.BusStopDao;
import com.kamalova.assetcontrol.dao.model.ReservationDao;
import com.kamalova.assetcontrol.dao.model.RouteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    RouteRepository routeRepository;

    @Autowired
    BusRepository busRepository;

    @Override
    public String createReservation(String routeName, String date, ReservationRequest reservationRequest) {
        RouteDao routeDao = routeRepository.findByRouteName(routeName)
                .orElseThrow(() -> new IllegalArgumentException("Route with name " + routeName + " doesn't exist"));

        BusStopDao busStopDao = busRepository.findByName(reservationRequest.getBusStop())
                .orElseThrow(() -> new IllegalArgumentException("Bus with name " + reservationRequest.getBusStop() + " doesn't exist"));
        String reservationId = UUID.randomUUID().toString();

        ReservationDao reservationDao = new ReservationDao(
                reservationId,
                routeDao,
                date,
                reservationRequest.getChildName(),
                busStopDao
        );

        reservationRepository.save(reservationDao);

        return reservationId;
    }

    @Override
    public void deleteReservation(String routeName, String date, String reservationId) {
        ReservationDao reservationDao = getReservation(routeName, date, reservationId);
        reservationRepository.delete(reservationDao);
    }

    @Override
    public List<ReservationDao> getReservationByDate(String routeName, String date) {
        return reservationRepository.findAllByDate(date)
                .stream()
                .filter(reservationDao -> reservationDao.getRoute().getRouteName().equals(routeName))
                .collect(Collectors.toList());
    }

    @Override
    public ReservationDao getReservationById(String routeName, String date, String reservationId) {
        return getReservation(routeName, date, reservationId);
    }

    @Override
    public void updateReservation(String routeName, String date, String reservationId,
                                  ReservationRequest reservationRequest) {
        ReservationDao reservationDao = getReservation(routeName, date, reservationId);
        RouteDao routeDao = routeRepository.findByRouteName(routeName)
                .orElseThrow(() -> new IllegalArgumentException("Route with name " + routeName + " doesn't exist"));

        BusStopDao busStopDao = busRepository.findByName(reservationRequest.getBusStop())
                .orElseThrow(() -> new IllegalArgumentException("Bus with name " + reservationRequest.getBusStop() + " doesn't exist"));

        reservationDao.setBusStop(busStopDao);
        reservationDao.setRoute(routeDao);
        reservationDao.setChildName(reservationRequest.getChildName());
        reservationDao.setDate(date);

        reservationRepository.save(reservationDao);
    }

    private ReservationDao getReservation(String routeName, String date, String reservationId) {
        ReservationDao reservationDao = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new IllegalArgumentException("Reservation with such ID doesn't exist"));
        if (!reservationDao.getDate().equals(date)) {
            throw new IllegalArgumentException("Incorrect date of reservation");
        }
        if (!reservationDao.getRoute().getRouteName().equals(routeName)) {
            throw new IllegalArgumentException("Incorrect route name of reservation");
        }
        return reservationDao;
    }


}
