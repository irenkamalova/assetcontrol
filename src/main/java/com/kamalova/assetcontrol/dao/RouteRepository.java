package com.kamalova.assetcontrol.dao;

import com.kamalova.assetcontrol.dao.model.RouteDao;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RouteRepository extends CrudRepository<RouteDao, String> {
    Optional<RouteDao> findByRouteName(String name);
}
