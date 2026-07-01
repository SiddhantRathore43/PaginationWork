package com.Spring.pagination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.pagination.entity.Employe;
import com.Spring.pagination.service.EmployeService;

@RestController
@RequestMapping("/employe")
public class EmployeController {

	@Autowired
	private EmployeService service;
	
	
	@GetMapping
	public Page<Employe> findAllEmps(@RequestParam int page,
									 @RequestParam int size ){
		return service.getAll(page, size);
	}
	
	@GetMapping("/email")
	public Page<Employe> findByDscEmail(@RequestParam int page,
										@RequestParam int size){
		return service.getByDescEmail(page, size);
	}
	
	@GetMapping("/Dname")
	public Page<Employe> findByDescName(@RequestParam int page,
			@RequestParam int size){
			return service.getByDesc(page, size);
}
	
	@GetMapping("/Aname")
	public Page<Employe> findByAescName(@RequestParam int page,
			@RequestParam int size){
			return service.getByAsc(page, size);
}
	
	@PostMapping("/AddAll")
	public List<Employe> addAllEmp(@RequestBody List<Employe> e){
		return service.insertAllEmp(e);
	}
	
	@PostMapping
	public Employe createEmploye(@RequestBody Employe ee) {
		return service.createEmp(ee);
	}
}
