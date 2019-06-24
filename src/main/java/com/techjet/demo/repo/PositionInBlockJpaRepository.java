package com.techjet.demo.repo;


import com.techjet.demo.entities.PositionInBlock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionInBlockJpaRepository extends JpaRepository<PositionInBlock, String> {
}
