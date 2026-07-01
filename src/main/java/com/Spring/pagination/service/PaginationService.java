package com.Spring.pagination.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.Spring.pagination.entity.customers;
import com.Spring.pagination.repository.PaginationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaginationService {

	
	@Autowired
	private PaginationRepository repo;
	
	public Page<customers> getAll(int page,int size){
		Pageable pageable = PageRequest.of(page, size);
		
		return repo.findAll(pageable);
		
		}
	
	public Page<customers> getCustomersinAsc(int page, int size) {

        Pageable pageable = PageRequest.of(page,size,Sort.by("name").ascending());

        return repo.findAll(pageable);
    }
	
	public Page<customers> getCustomersinDesc(int page,int size){
		Pageable pagebale = PageRequest.of(page, size,Sort.by("name").descending());
		
		return repo.findAll(pagebale);
	}
	
	public Page<customers> getCustomerByEmailAsc(int page , int size){
		Sort sort = Sort.by(Sort.Direction.ASC,"email");
		
		Pageable pageable = PageRequest.of(page, size,sort);
		return repo.findAll(pageable);
	}
	
}
