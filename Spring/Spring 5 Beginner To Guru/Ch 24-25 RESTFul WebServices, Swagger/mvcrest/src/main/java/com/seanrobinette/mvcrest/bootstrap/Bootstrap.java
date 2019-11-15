package com.seanrobinette.mvcrest.bootstrap;

import com.seanrobinette.mvcrest.domain.Category;
import com.seanrobinette.mvcrest.domain.Customer;
import com.seanrobinette.mvcrest.domain.Vendor;
import com.seanrobinette.mvcrest.repositories.CategoryRepository;
import com.seanrobinette.mvcrest.repositories.CustomerRepository;
import com.seanrobinette.mvcrest.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final CustomerRepository customerRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, CustomerRepository customerRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.customerRepository = customerRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category fruits = new Category();
        fruits.setName("fruits");

        Category dried = new Category();
        dried.setName("dried");

        Category fresh = new Category();
        fresh.setName("fresh");

        Category exotic = new Category();
        exotic.setName("exotic");

        Category nuts = new Category();
        nuts.setName("nuts");

        categoryRepository.save(fruits);
        categoryRepository.save(dried);
        categoryRepository.save(fresh);
        categoryRepository.save(exotic);
        categoryRepository.save(nuts);
        System.out.println("Categories loaded: " + categoryRepository.count());

        Customer joe = new Customer();
        joe.setFirstName("Joe");
        joe.setLastName("Buck");

        Customer david = new Customer();
        david.setFirstName("David");
        david.setLastName("Winter");

        Customer alice = new Customer();
        alice.setFirstName("Alice");
        alice.setLastName("Eastman");

        customerRepository.save(joe);
        customerRepository.save(david);
        customerRepository.save(alice);
        System.out.println("Customers loaded: " + customerRepository.count());

        Vendor fruitVendor = new Vendor();
        fruitVendor.setName("Western Tasty Fruits Ltd.");

        Vendor exoticFruits = new Vendor();
        exoticFruits.setName("Exotic Fruits Company");

        vendorRepository.save(fruitVendor);
        vendorRepository.save(exoticFruits);
        System.out.println("Vendors loaded: " + vendorRepository.count());
    }
}
