package com.robinette.services.springdatajpa;

import com.robinette.model.Owner;
import com.robinette.model.PetType;
import com.robinette.repositories.OwnerRepository;
import com.robinette.repositories.PetRepository;
import com.robinette.repositories.PetTypeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerJpaService ownerJpaService;

    Set<Owner> owners;
    Owner returnOwner;

    @BeforeEach
    void setUp() {
        owners = new HashSet<>();
        owners.add(Owner.builder().id(1L).build());
        owners.add(Owner.builder().id(2L).build());
        returnOwner = Owner.builder().id(3L).lastName(LAST_NAME).build();
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);

        Owner smith = ownerJpaService.findByLastName(LAST_NAME);

        assertEquals(smith.getLastName(), LAST_NAME);
        verify(ownerRepository).findByLastName(LAST_NAME);
    }

    @Test
    void findAll() {
        when(ownerRepository.findAll()).thenReturn(owners);

        assertEquals(ownerJpaService.findAll(), owners);
        verify(ownerRepository).findAll();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(3L)).thenReturn(Optional.of(returnOwner));
        assertEquals(ownerJpaService.findById(3L), returnOwner);
        verify(ownerRepository).findById(any());
    }

    @Test
    void save() {
        when(ownerRepository.save(returnOwner)).thenReturn(returnOwner);

        Owner savedOwner = ownerJpaService.save(returnOwner);

        assertEquals(savedOwner, returnOwner);
        verify(ownerRepository).save(any());
    }

    @Test
    void deleteByObject() {
        ownerJpaService.deleteByObject(returnOwner);

        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerJpaService.deleteById(returnOwner.getId());

        verify(ownerRepository).deleteById(any());
    }
}