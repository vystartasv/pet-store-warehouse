package com.vilius.petstore.repository;

import com.vilius.petstore.entity.Pet;
import com.vilius.petstore.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findByNameOrderById(String name);

    List<Pet> findByTypeOrderById(Type type);

    Pet findFirstByOrderByIdDesc();
}
