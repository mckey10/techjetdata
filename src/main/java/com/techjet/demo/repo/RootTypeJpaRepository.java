package com.techjet.demo.repo;

import com.techjet.demo.entities.RootType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RootTypeJpaRepository extends JpaRepository<RootType, String> {
}
