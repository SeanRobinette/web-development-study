package com.robinette.services.map;

import java.util.Set;

import com.robinette.model.Vet;
import com.robinette.services.VetService;

public class VetMapService extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void deleteByObject(Vet obj) {
        super.deleteByObject(obj);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet save(Long id, Vet object) {
        return super.save(id, object);
    }
}