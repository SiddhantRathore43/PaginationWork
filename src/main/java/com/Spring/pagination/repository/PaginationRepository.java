package com.Spring.pagination.repository;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Spring.pagination.entity.customers;

@Repository
public interface PaginationRepository extends JpaRepository<customers,Long> {

	
	Page<customers> findAll(Pageable pageable);
}
