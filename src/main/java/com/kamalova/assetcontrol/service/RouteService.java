package com.kamalova.assetcontrol.service;

import com.kamalova.assetcontrol.dao.model.RouteDao;

public interface RouteService {

    Iterable<RouteDao> getAllRoute();

    RouteDao getRouteByName(String name);
}
