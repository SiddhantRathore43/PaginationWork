package com.Spring.pagination.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Spring.pagination.entity.Employe;
@Repository
public interface EmployeRepository extends JpaRepository<Employe,Long> {

	Page<Employe> findAll(Pageable pageable);
	
	
}
