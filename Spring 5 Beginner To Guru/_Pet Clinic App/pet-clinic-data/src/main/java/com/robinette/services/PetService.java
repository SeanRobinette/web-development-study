package com.robinette.services;

import java.util.Set;

import com.robinette.model.Pet;

public interface PetService {
    Pet findById(Long id);
    Pet save(Pet Pet);
    Set<Pet> findAll();
}