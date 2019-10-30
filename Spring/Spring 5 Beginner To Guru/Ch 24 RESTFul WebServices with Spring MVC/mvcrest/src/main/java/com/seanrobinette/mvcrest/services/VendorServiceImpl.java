package com.seanrobinette.mvcrest.services;

import com.seanrobinette.mvcrest.api.v1.mapper.VendorMapper;
import com.seanrobinette.mvcrest.api.v1.model.VendorDTO;
import com.seanrobinette.mvcrest.controllers.VendorController;
import com.seanrobinette.mvcrest.domain.Vendor;
import com.seanrobinette.mvcrest.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VendorServiceImpl implements VendorService {
    private final VendorRepository vendorRepository;
    private final VendorMapper vendorMapper;

    public VendorServiceImpl(VendorRepository vendorRepository, VendorMapper vendorMapper) {
        this.vendorRepository = vendorRepository;
        this.vendorMapper = vendorMapper;
    }

    @Override
    public List<VendorDTO> getAll() {
        List<Vendor> vendors = vendorRepository.findAll();
        List<VendorDTO> vendorDTOS = new ArrayList<>();
        for(Vendor vendor : vendors) {
            VendorDTO vendorDTO = vendorMapper.vendorToVendorDTO(vendor);
            vendorDTO.setVendorUrl(VendorController.API_ROOT + vendor.getId());
            vendorDTOS.add(vendorDTO);
        }
        return vendorDTOS;
    }

    @Override
    public VendorDTO getById(Long id) {
        Optional<Vendor> vendorOptional = vendorRepository.findById(id);
        if(!vendorOptional.isPresent())
            throw new ResourceNotFoundException();
        Vendor vendor = vendorOptional.get();
        VendorDTO returnDto = vendorMapper.vendorToVendorDTO(vendor);
        returnDto.setVendorUrl(VendorController.API_ROOT + vendor.getId());
        return returnDto;
    }

    @Override
    public VendorDTO createNewVendor(VendorDTO vendorDTO) {
        Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);
        Vendor savedVendor = vendorRepository.save(vendor);
        VendorDTO returnDto = vendorMapper.vendorToVendorDTO(savedVendor);
        returnDto.setVendorUrl(VendorController.API_ROOT + savedVendor.getId());
        return returnDto;
    }

    @Override
    public VendorDTO updateVendor(Long id, VendorDTO vendorDTO) {
        Vendor vendor = vendorMapper.vendorDTOToVendor(vendorDTO);
        vendor.setId(id);
        Vendor savedVendor = vendorRepository.save(vendor);
        VendorDTO returnDto = vendorMapper.vendorToVendorDTO(savedVendor);
        returnDto.setVendorUrl(VendorController.API_ROOT + savedVendor.getId());
        return returnDto;
    }

    @Override
    public VendorDTO patchVendor(Long id, VendorDTO vendorDTO) {
        // Look up the Vendor
        Optional<Vendor> vendorOptional = vendorRepository.findById(id);
        // If it's not found, throw an exception
        if(!vendorOptional.isPresent())
            throw new ResourceNotFoundException();
        Vendor vendor = vendorOptional.get();
        // Update all fields that weren't null on the request object
        if(vendorDTO.getName() != null)
            vendor.setName(vendorDTO.getName());
        // Save the updated Vendor
        Vendor savedVendor = vendorRepository.save(vendor);
        // Return the saved Vendor
        VendorDTO returnDto = vendorMapper.vendorToVendorDTO(savedVendor);
        returnDto.setVendorUrl(VendorController.API_ROOT + vendor.getId());
        return returnDto;
    }

    @Override
    public void deleteVendorById(Long id) {
        if(!vendorRepository.findById(id).isPresent())
            throw new ResourceNotFoundException();
        vendorRepository.deleteById(id);
    }
}
