package com.kamalova.assetcontrol.service;

import com.kamalova.assetcontrol.dao.BusRepository;
import com.kamalova.assetcontrol.dao.ReservationRepository;
import com.kamalova.assetcontrol.dao.RouteRepository;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class ReservationServiceTest {
    @MockBean
    ReservationRepository reservationRepository;

    @MockBean
    BusRepository busRepository;

    @MockBean
    RouteRepository routeRepository;

    /*
    test methods of reservation service the same as in routeServiceTest
     */
}