package com.kamalova.assetcontrol.api.controller;

import com.kamalova.assetcontrol.dao.model.RouteDao;
import com.kamalova.assetcontrol.service.RouteService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "assetcontrol", path = "/service")
@Api(value = "School Bus reservation system")
public class RoutesControllerImpl extends AssetControlController
        implements RoutesController {

    @Autowired
    private RouteService routeService;

    @Override
    public Iterable<RouteDao> getAllRoutes() {
        return routeService.getAllRoute();
    }

    @Override
    public RouteDao getRouteByName(String name) {
        return routeService.getRouteByName(name);
    }
}