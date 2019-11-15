package com.seanrobinette.mvcrest.repositories;

import com.seanrobinette.mvcrest.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
    Optional<Vendor> findById(Long id);
}
