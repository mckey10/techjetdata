package com.techjet.demo.repo;

import com.techjet.demo.entities.Block;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlockJpaRepository extends JpaRepository<Block, String> {
}
