package com.faisal.dealertrial.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.faisal.dealertrial.dao.SalesDAO;
import com.faisal.dealertrial.entity.Sales;

@Service
public class SalesServices implements UserDetailsService{
	@Autowired
	SalesDAO salesDAO;

	@Override
	public UserDetails loadUserByUsername(String salesname) throws UsernameNotFoundException {
		
			Sales sale = salesDAO.findBysalesname(salesname);
			if (sale != null) {
				GrantedAuthority authority = new SimpleGrantedAuthority(sale.getStatus());
				return new User(sale.getSalesname(), sale.getPassword(), Arrays.asList(authority));
			}else {
				throw new UsernameNotFoundException("SALES NOT FOUND");
			}
		}

	
	
}
