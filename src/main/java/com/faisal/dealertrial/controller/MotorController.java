package com.faisal.dealertrial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faisal.dealertrial.dao.MotorDAO;

@RestController
@RequestMapping("api/v1/saleslogin/")
public class MotorController {
	@Autowired
	MotorDAO motorDAO;

}
