package com.faisal.dealertrial.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faisal.dealertrial.dao.MotorDAO;
import com.faisal.dealertrial.entity.Motor;

@Controller
@RestController
@RequestMapping("api/v1/saleslogin/bigbike/")
public class MotorBigBikeController {
	@Autowired
	MotorDAO motorDAO;
	
	@GetMapping("getAllBigBike")
	public List<Object[]> getAllBigBike(){
		List<Object[]> result = motorDAO.findBigBike();
		
		return result;
	}

}
