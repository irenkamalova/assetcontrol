package com.kamalova.assetcontrol.service;

import com.kamalova.assetcontrol.dao.RouteRepository;
import com.kamalova.assetcontrol.dao.model.RouteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteRepository routeRepository;


    @Override
    public Iterable<RouteDao> getAllRoute() {
        return routeRepository.findAll();
    }

    @Override
    public RouteDao getRouteByName(String name) {
        return routeRepository.findByRouteName(name)
                .orElseThrow(() -> new IllegalArgumentException("Route with name " + name + " doesn't exist"));
    }
}
