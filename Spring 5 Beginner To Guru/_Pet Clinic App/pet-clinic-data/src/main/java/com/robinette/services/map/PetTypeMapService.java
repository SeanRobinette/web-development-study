package com.robinette.services.map;

import com.robinette.model.PetType;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> {
    @Override
    Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    PetType findById(Long id) {
        return super.findById(id);
    }

    @Override
    PetType save(PetType object) {
        return super.save(object);
    }

    @Override
    void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    void deleteByObject(PetType obj) {
        super.deleteByObject(obj);
    }
}
