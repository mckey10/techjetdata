package com.techjet.demo.repo;


import com.techjet.demo.entities.Fixture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FixtureJpaRepository extends JpaRepository<Fixture, String>{

}
