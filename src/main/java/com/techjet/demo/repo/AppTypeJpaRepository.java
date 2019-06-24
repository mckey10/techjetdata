package com.techjet.demo.repo;


import com.techjet.demo.entities.AppType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface AppTypeJpaRepository extends JpaRepository<AppType, String> {
    @Query(value="SELECT a FROM AppType a JOIN a.tool t WHERE t.nameTool = ?1")
    public Set<AppType> getToolJPQL(String nameTool);
}

