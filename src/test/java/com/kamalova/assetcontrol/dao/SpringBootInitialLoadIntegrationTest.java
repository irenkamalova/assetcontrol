package com.kamalova.assetcontrol.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class SpringBootInitialLoadIntegrationTest {
    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private BusRepository busRepository;

    @Test
    public void testLoadData() {

        assertTrue(routeRepository.findById("0").isPresent());
        assertTrue(routeRepository.findById("1").isPresent());
        assertTrue(busRepository.findById("0").isPresent());
        assertTrue(busRepository.findById("9").isPresent());

        assertEquals(routeRepository.findById("0").get(),
                busRepository.findById("0").get().getRouteList().iterator().next());

        assertEquals(routeRepository.findById("1").get(),
                busRepository.findById("9").get().getRouteList().iterator().next());
    }

}
