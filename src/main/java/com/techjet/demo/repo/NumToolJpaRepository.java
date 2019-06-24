package com.techjet.demo.repo;


import com.techjet.demo.entities.NumTool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface NumToolJpaRepository  extends JpaRepository<NumTool, String> {
    @Query(value="SELECT n FROM NumTool n JOIN n.tool t WHERE t.nameTool = ?1")
    public Set<NumTool> getToolJPQL1(String nameTool);
}
