package com.devopseducation.simplerestapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devopseducation.simplerestapi.model.Professional;

@RestController
@RequestMapping("/professionals")
public class ProfessionalController {
	
	private List<Professional> professionals;
	
	ProfessionalController(){
		professionals = new ArrayList<Professional>();
		
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
	}
	
	
	@GetMapping("/list")
	List<Professional> all() {
	  return this.professionals;
	}
	
	
	@PostMapping("/add")
	public ResponseEntity<HttpStatus> postController(
	  @RequestBody Professional professional) {
		
		Professional newProfessional = new Professional();
		newProfessional.setId(professional.getId());
		newProfessional.setName(professional.getName());
		newProfessional.setRole(professional.getRole());
		professionals.add(newProfessional);
		
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public @ResponseBody ResponseEntity<String> delete(@PathVariable(value = "id") String id) {
		
		boolean professionalRemoved = professionals.removeIf(e -> e.getId().equals(id));
		
		if(professionalRemoved) {
			return new ResponseEntity<String>("Success: Professional deleted", HttpStatus.OK);
		
		}else {
			return new ResponseEntity<String>("Failure: Id not found", HttpStatus.BAD_REQUEST);
		}
		
	}

}
