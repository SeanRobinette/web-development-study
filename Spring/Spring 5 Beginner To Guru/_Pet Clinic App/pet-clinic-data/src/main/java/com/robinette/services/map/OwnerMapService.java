package com.robinette.services.map;

import java.util.Set;

import com.robinette.model.Owner;
import com.robinette.services.OwnerService;

import com.robinette.services.PetService;
import com.robinette.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile({"default", "map"})
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerMapService(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

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
    public Owner save(Owner object) {
        if(object!=null) {
            if(object.getPets() != null) {
                object.getPets().forEach(pet -> {
                    if (pet.getPetType().getId() != null) {
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    } else {
                        throw new RuntimeException("PetType is required");
                    }
                    petService.save(pet);
                });
            }
            return super.save(object);
        }
        return null;
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