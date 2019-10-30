package com.seanrobinette.mvcrest.services;

import com.seanrobinette.mvcrest.api.v1.model.VendorDTO;

import java.util.List;

public interface VendorService {
    List<VendorDTO> getAll();
    VendorDTO getById(Long id);
    VendorDTO createNewVendor(VendorDTO vendorDTO);
    VendorDTO updateVendor(Long id, VendorDTO vendorDTO);
    VendorDTO patchVendor(Long id, VendorDTO vendorDTO);
    void deleteVendorById(Long id);
}
