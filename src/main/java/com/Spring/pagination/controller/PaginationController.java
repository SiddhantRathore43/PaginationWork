package com.Spring.pagination.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Spring.pagination.entity.customers;
import com.Spring.pagination.service.PaginationService;


@RestController
@RequestMapping("/customers")
//@CrossOrigin(origins = "*")
public class PaginationController {

	@Autowired
	private PaginationService service;

	@GetMapping
	public Page<customers> getCustommers(
			@RequestParam int page ,
			@RequestParam int size) {
		
		return service.getAll(page, size);
				
			}
	
	@GetMapping("/SortAsc")
	public Page<customers> getAsc(
			@RequestParam(defaultValue = "0")int page,
			@RequestParam(defaultValue = "5")int size){
		return service.getCustomersinAsc(page, size);
	}
	
	@GetMapping("/SortDesc")
	public Page<customers> getDesc(
			@RequestParam(defaultValue = "0")int page,
			@RequestParam(defaultValue = "5")int size){
		return service.getCustomersinDesc(page, size);
	}
	
	@GetMapping("/sortbyemail=")
	public Page<customers> getByEmailAsc(@RequestParam int page,
										 @RequestParam int size){
				return service.getCustomerByEmailAsc(page, size);							 
											 
	 }
}
