package com.Spring.pagination.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.Spring.pagination.entity.Employe;
import com.Spring.pagination.repository.EmployeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeService {

	@Autowired
	private EmployeRepository repo;
	
	
	public Page<Employe> getAll(int page,int size){
		
		Pageable pageable = PageRequest.of(page, size);
		
		return repo.findAll(pageable);
	}
	
	
	public Page<Employe> getByAsc(int page,int size){
		
		Pageable pageable = PageRequest.of(page, size,Sort.by("name"));
		
		return repo.findAll(pageable);
	}
	
	public Page<Employe> getByDescEmail(int page, int size) {

	    Sort sort = Sort.by(Sort.Direction.DESC, "email");

	    Pageable pageable = PageRequest.of(page, size, sort);

	    return repo.findAll(pageable);
	}
	
	
	public Page<Employe> getByDesc(int page,int size){
		Sort sort = Sort.by(Sort.Direction.DESC,"name");
		
		Pageable pageable = PageRequest.of(page, size, sort);
			
			return repo.findAll(pageable);
		}
	
	
	public List<Employe> insertAllEmp(List<Employe> ee){
		return repo.saveAll(ee);
	}
	
	public Employe createEmp(Employe ee) {
		return repo.save(ee);
	}
	}
	

