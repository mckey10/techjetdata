package com.techjet.demo.repo;


import com.techjet.demo.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialsJpaRepository extends JpaRepository<Material, String>{



}

