package com.kamalova.assetcontrol.dao;

import com.kamalova.assetcontrol.dao.model.ReservationDao;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<ReservationDao, String> {
    List<ReservationDao> findAllByDate(String date);
}
