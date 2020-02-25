package com.kamalova.assetcontrol.service;

import com.kamalova.assetcontrol.dao.RouteRepository;
import com.kamalova.assetcontrol.dao.model.RouteDao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
class RouteServiceTest {
    private static RouteDao routeDao;
    @Autowired
    RouteService routeService;
    @MockBean
    RouteRepository routeRepository;

    @BeforeAll
    public static void init() {
        routeDao = new RouteDao("1", "rA", null, null);
    }

    @Test
    void getAllRoute() {
        given(routeRepository.findAll()).willReturn(Collections.singletonList(routeDao));
        assertEquals(routeDao, routeService.getAllRoute().iterator().next());
    }

    @Test
    void getRouteByName() {
        String routeName = "rA";
        given(routeRepository.findByRouteName(routeName))
                .willReturn(Optional.of(routeDao));

        assertEquals(routeDao, routeService.getRouteByName(routeName));
    }
}