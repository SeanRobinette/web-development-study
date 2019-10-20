package com.robinette.services.map;

import java.util.Set;

import com.robinette.model.Owner;
import com.robinette.services.OwnerService;

public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void deleteByObject(Owner obj) {
        super.deleteByObject(obj);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Long id, Owner object) {
        return super.save(id, object);
    }
    public Owner findByLastName(String lastName) {
        return map.entrySet()
                  .stream()
                  .filter(obj -> {return obj.getValue().getLastName() == lastName;})
                  .findAny()
                  .orElse(null)
                  .getValue();
    }
}