package com.mojdan.admin.model.address;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {

	List<Address> findAll();

	Optional<Address> findById(Long id);
}
