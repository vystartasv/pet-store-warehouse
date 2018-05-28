package com.vilius.petstore.service;

import com.vilius.petstore.entity.Address;
import com.vilius.petstore.repository.AddressRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public Address addAddress(Address address){
        addressRepository.saveAndFlush(address);
        return addressRepository.findFirstByOrderByIdDesc();
    }

    public Address getAddressById(Long id){ return addressRepository.findById(id).get(); }

    public void deleteAddressById(Long id){addressRepository.deleteById(id);}
}
