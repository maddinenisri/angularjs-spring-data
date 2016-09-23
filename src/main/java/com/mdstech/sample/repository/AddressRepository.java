package com.mdstech.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mdstech.sample.domain.AddressEntity;
import org.springframework.stereotype.Repository;

@Repository("addressRepository")
public interface AddressRepository
		extends
			JpaRepository<AddressEntity, Integer> {
}