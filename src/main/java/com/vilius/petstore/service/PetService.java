package com.vilius.petstore.service;

import com.vilius.petstore.entity.Pet;
import com.vilius.petstore.entity.Type;
import com.vilius.petstore.repository.PetRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@NoArgsConstructor
@Service
public class PetService {
    @Autowired
    PetRepository petRepository;

    public Pet addPet(Pet pet) {
        petRepository.saveAndFlush(pet);
        return petRepository.findFirstByOrderByIdDesc();
    }

    public void removePet(Long id) {
        petRepository.deleteById(id);
    }

    public Pet getPetById(Long id) {
        return petRepository.findById(id).get();
    }

    public List<Pet> getPetByName(String name) {
        return petRepository.findByNameOrderById(name);
    }

    public Pet changePetName(Long id, String name) {
        getPetById(id).setName(name);
        getPetById(id).setUpdated(Calendar.getInstance());
        petRepository.flush();
        return getPetById(id);
    }

    public Pet getLastPetAdded() {
        return petRepository.findFirstByOrderByIdDesc();
    }

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public List<Pet> getPetByType(Type type) {
        return petRepository.findByTypeOrderById(type);
    }

}
