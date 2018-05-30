package com.vilius.petstore.wrapper;

import com.vilius.petstore.entity.Pet;
import com.vilius.petstore.entity.Type;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetWrapper {

    private Type type;

    private String name;

    private String breed;

    private int age;

    public PetWrapper(Pet pet) {
        this.type = pet.getType();
        this.name = pet.getName();
        this.breed = pet.getBreed();
        this.age = pet.getAge();
    }
}
