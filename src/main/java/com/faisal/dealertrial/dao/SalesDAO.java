package com.faisal.dealertrial.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.faisal.dealertrial.entity.Sales;

public interface SalesDAO extends CrudRepository<Sales, Integer>{

	public Sales findBysalesname(String salesname);




		

}
