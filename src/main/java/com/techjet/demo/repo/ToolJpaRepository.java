package com.techjet.demo.repo;

import com.techjet.demo.entities.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolJpaRepository extends JpaRepository<Tool, String> {
}
