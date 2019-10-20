package com.robinette.bootstrap;

import com.robinette.model.Owner;
import com.robinette.model.Vet;
import com.robinette.services.OwnerService;
import com.robinette.services.VetService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

	@Override
	public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Sean");
        owner1.setLastName("Robinette");
        ownerService.save(1L, owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Bob");
        owner2.setLastName("McBobson");
        ownerService.save(2L, owner2);
        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Smith");
        vetService.save(1L, vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Jane");
        vet2.setLastName("Smith");
        vetService.save(2L, vet2);
        System.out.println("Loaded pets...");
	}
}