package com.kamalova.assetcontrol.api.controller;

import com.kamalova.assetcontrol.dao.model.RouteDao;
import com.kamalova.assetcontrol.service.RouteService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RoutesController.class)
class RoutesControllerTest {

    private static RouteDao routeDao;
    @Autowired
    private MockMvc mvc;
    @MockBean
    private RouteService service;

    @BeforeAll
    public static void init() {
        routeDao = new RouteDao("1", "rA", null, null);
    }

    @DisplayName("Route controller should provide method to get all routes")
    @Test
    public void getAllRoutes() throws Exception {
        given(service.getAllRoute()).willReturn(Collections.singletonList(routeDao));

        mvc.perform(get("/service/routes/"))
                .andExpect(status().isOk());
    }

    @DisplayName("Route controller should provide method to get route by name")
    @Test
    public void getRouteByName() throws Exception {
        String routeName = "rA";
        given(service.getRouteByName(routeName)).willReturn(routeDao);


        mvc.perform(get("/service/routes/" + routeName))
                .andExpect(status().isOk())
                .andExpect(jsonPath("routeName", is(routeName)));
    }
}