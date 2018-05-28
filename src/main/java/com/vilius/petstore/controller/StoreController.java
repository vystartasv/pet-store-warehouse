package com.vilius.petstore.controller;

import com.vilius.petstore.entity.Address;
import com.vilius.petstore.entity.Pet;
import com.vilius.petstore.entity.Type;
import com.vilius.petstore.entity.User;
import com.vilius.petstore.service.AddressService;
import com.vilius.petstore.service.PetService;
import com.vilius.petstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StoreController {

    @Autowired
    PetService petService;

    @Autowired
    UserService userService;

    @Autowired
    AddressService addressService;

    @GetMapping("/pets/id/{id}")
    public Pet getPetById(@PathVariable("id") Long id){
        return petService.getPetById(id);
    }

    @GetMapping("/pets/type/{type}")
    public List<Pet> getPetById(@PathVariable("type") Type type){
        return petService.getPetByType(type);
    }

    @GetMapping("/pets")
    public List<Pet> getPetByName(@RequestParam(value="name") String name){
        return petService.getPetByName(name);
    }

    @PostMapping("/pets")
    public Pet addPet(@RequestBody Pet pet){
        petService.addPet(pet);
        return petService.getLastPetAdded();
    }

    @PutMapping("/pets/id/{id}")
    public Pet changePetName(@PathVariable("id") Long petId, @RequestBody String newName){
        petService.changePetName(petId, newName);
        return petService.getPetById(petId);
    }

    @GetMapping("/pets/all")
    public List<Pet> getAllPets(){return petService.getAllPets();}

    @PostMapping("/users")
    public User addUser(@RequestBody User user){return userService.addUser(user);}

    @PostMapping("/addresses")
    public Address addAddress(@RequestBody Address address){return addressService.addAddress(address);}

    @GetMapping("/users/id/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return  userService.getUserById(id);
    }

    @GetMapping("/addresses/id/{id}")
    public Address getAddressById(@PathVariable("id") Long id){
        return addressService.getAddressById(id);
    }

}
