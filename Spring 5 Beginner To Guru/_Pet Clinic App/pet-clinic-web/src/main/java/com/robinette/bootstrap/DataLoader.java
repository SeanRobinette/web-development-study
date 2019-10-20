package com.robinette.bootstrap;

import com.robinette.model.Owner;
import com.robinette.model.PetType;
import com.robinette.model.Vet;
import com.robinette.services.OwnerService;
import com.robinette.services.PetTypeService;
import com.robinette.services.VetService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

	@Override
	public void run(String... args) throws Exception {
        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        PetType dog = new PetType();
        dog.setName("dog");
        PetType savedDogPetType = petTypeService.save(dog);

        Owner owner1 = new Owner();
        owner1.setFirstName("Sean");
        owner1.setLastName("Robinette");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bob");
        owner2.setLastName("McBobson");
        ownerService.save(owner2);
        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Smith");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jane");
        vet2.setLastName("Smith");
        vetService.save(vet2);
        System.out.println("Loaded pets...");
	}
}