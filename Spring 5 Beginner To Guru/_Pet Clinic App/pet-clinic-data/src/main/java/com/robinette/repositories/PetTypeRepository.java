package com.robinette.repositories;

import com.robinette.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<Pet, Long> {
}
