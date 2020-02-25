package com.kamalova.assetcontrol.dao;

import com.kamalova.assetcontrol.dao.model.BusStopDao;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BusRepository extends CrudRepository<BusStopDao, String> {
    Optional<BusStopDao> findByName(String name);
}
