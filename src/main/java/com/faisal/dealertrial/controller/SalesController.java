package com.faisal.dealertrial.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faisal.dealertrial.dao.SalesDAO;
import com.faisal.dealertrial.entity.Sales;

@RestController
@Controller
@RequestMapping(value = "api/v1/saleslogin/")
public class SalesController {
	
	@Autowired
	SalesDAO salesDAO;
	
	@RequestMapping("bike")
	public HashMap<String, Object> standart(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Masuk sebagai sales");
		return map;
	}
	
	@RequestMapping("bigbike")
	public HashMap<String, Object> bigbike(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Masuk sebagai sales Bigbike");
		return map;
	}
	@RequestMapping("admin")
	public HashMap<String, Object> admin(){
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Masuk sebagai ADMIN Sales");
		return map;
	}
	
	@GetMapping(value = "admin/getSales/")
	public List<Sales> getAllSales(){
		List<Sales> result = new ArrayList<Sales>();
		
		salesDAO.findAll().forEach(result::add);
		return result;
	}
	@PostMapping(value = "admin/addSales/")
	public Sales addSales (@RequestBody Sales sales) {
		
		try {
			sales.setPassword(new BCryptPasswordEncoder().encode(sales.getPassword()));
			return salesDAO.save(sales);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@PutMapping(value = "admin/updateSales/{id}")
	public Sales updateSales (@RequestBody Sales sales, @PathVariable Integer id) {
		Sales salesSelect = salesDAO.findById(id).orElse(null);
		
		
		if (salesSelect != null) {
			salesSelect.setSalesname(sales.getSalesname());
			salesSelect.setStatus(sales.getStatus());
			salesSelect.setPassword(new BCryptPasswordEncoder().encode(sales.getPassword()));
			
			return salesDAO.save(salesSelect);
		}else {
			return null;
		}
				
	}
	
}
