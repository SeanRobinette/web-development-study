package com.robinette.bootstrap;

import com.robinette.model.*;
import com.robinette.services.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

	@Override
	public void run(String... args) throws Exception {
        if(petTypeService.findAll().size() == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);
        Specialty surgery = new Specialty();
        radiology.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);
        Specialty dentistry = new Specialty();
        radiology.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Sean");
        owner1.setLastName("Robinette");
        owner1.setAddress("123 Brickerel Street");
        owner1.setCity("Miami");
        owner1.setTelephone("(123) 456-7890");

        Pet luke = new Pet();
        luke.setName("Luke Pawwalker");
        luke.setPetType(cat);
        luke.setBirthDate(LocalDate.now());
        luke.setOwner(owner1);
        owner1.getPets().add(luke);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bob");
        owner2.setLastName("McBobson");
        owner2.setAddress("543 Fake Street");
        owner2.setCity("New York");
        owner2.setTelephone("(123) 456-7890");

        Pet katy = new Pet();
        katy.setName("Katy Purry");
        katy.setPetType(cat);
        katy.setBirthDate(LocalDate.now());
        katy.setOwner(owner2);
        owner2.getPets().add(katy);
        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Smith");
        vet1.getSpecialties().add(savedDentistry);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jane");
        vet2.setLastName("Smith");
        vet2.getSpecialties().add(savedSurgery);
        vetService.save(vet2);
        System.out.println("Loaded vets...");
        
        Visit lukeVisit = new Visit();
        lukeVisit.setPet(luke);
        lukeVisit.setDate(LocalDate.now());
        lukeVisit.setDescription("Dying of lack of cuddles");
        visitService.save(lukeVisit);
    }
}