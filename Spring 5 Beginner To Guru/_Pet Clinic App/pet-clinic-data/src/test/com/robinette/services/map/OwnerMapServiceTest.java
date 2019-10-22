package com.robinette.services.map;

import com.robinette.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    Long[] ownerIds = {1L,2L,3L};

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetMapService(), new PetTypeMapService());
        for(Long ownerId : ownerIds)
            ownerMapService.save(Owner.builder().id(ownerId).build());
    }

    @Test
    void deleteById() {
        int startSize = ownerMapService.findAll().size();
        assertNotNull(ownerMapService.findById(ownerIds[0]));

        ownerMapService.deleteById(ownerIds[0]);

        assertEquals(startSize - 1, ownerMapService.findAll().size());
        assertNull(ownerMapService.findById(ownerIds[0]));
    }

    @Test
    void deleteByObject() {
        int startSize = ownerMapService.findAll().size();

        Owner toDelete = ownerMapService.save(Owner.builder().build());
        ownerMapService.deleteByObject(toDelete);

        assertEquals(startSize, ownerMapService.findAll().size());
        assertFalse(ownerMapService.findAll().contains(toDelete));
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();

        assertEquals(owners.size(), ownerIds.length);
    }

    @Test
    void findById() {
        for(Long ownerId : ownerIds) {
            Owner owner = ownerMapService.findById(ownerId);
            assertEquals(owner.getId(), ownerId);
        }
    }

    @Test
    void saveNewId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().id(0L).build());

        assertEquals(savedOwner.getId(), Long.valueOf(0L));
    }

    @Test
    void saveExistingId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().id(ownerIds[0]).build());

        assertEquals(savedOwner.getId(), Long.valueOf(ownerIds[0]));
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findByLastName() {
        ownerMapService.save((Owner.builder().id(0L).lastName("Smith").build()));
        Owner smith = ownerMapService.findByLastName("Smith");
        assertEquals(smith.getId(), Long.valueOf(0L));
    }
}