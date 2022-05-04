package com.devopseducation.simplerestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devopseducation.simplerestapi.model.Professional;

@RestController
@RequestMapping("/professionals")
public class ProfessionalController {
	
	
	@GetMapping("/list")
	List<Professional> all() {
	  return getProfessionals();
	}
	
	private List<Professional> getProfessionals() {
		List<Professional> professionals = new ArrayList<Professional>();
		
		Professional one = new Professional();
		one.setId("A0001");
		one.setName("Luis");
		one.setRole("Developer");

		Professional two = new Professional();
		two.setId("A0002");
		two.setName("Siul");
		two.setRole("Network Admin");
		
		professionals.add(one);
		professionals.add(two);
		
		return professionals;
	}

}
