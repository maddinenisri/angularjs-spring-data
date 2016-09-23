package com.mdstech.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mdstech.sample.domain.EmployeeEntity;
import org.springframework.stereotype.Repository;

@Repository("employeeRepository")
public interface EmployeeRepository
		extends
			JpaRepository<EmployeeEntity, Integer> {
}