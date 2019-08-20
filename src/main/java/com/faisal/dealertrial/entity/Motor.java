package com.faisal.dealertrial.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Setter;
import lombok.Getter;

@Data
@Entity
@Getter
@Setter
@Table(name = "motor")
public class Motor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	private String tipe;
	private String jenis;

}
