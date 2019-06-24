package com.techjet.demo.repo;


import com.techjet.demo.entities.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachinesJpaRepository extends JpaRepository<Machine, String> {
}
