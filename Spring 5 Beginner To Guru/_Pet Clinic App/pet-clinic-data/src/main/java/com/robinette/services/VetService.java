package com.robinette.services;

import java.util.Set;

import com.robinette.model.Vet;

public interface VetService {
    Vet findById(Long id);
    Vet save(Vet Vet);
    Set<Vet> findAll();
}