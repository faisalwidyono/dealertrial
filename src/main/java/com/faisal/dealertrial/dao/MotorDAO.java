package com.faisal.dealertrial.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.faisal.dealertrial.entity.Motor;

public interface MotorDAO extends CrudRepository<Motor, Integer>{

	@Query(value = "SELECT m FROM motor m WHERE m.jenis LIKE 'bigbike'; ")
	public List<Object[]> findBigBike();
}
