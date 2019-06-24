package com.techjet.demo.repo;



import com.techjet.demo.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface OperationsJpaRepository extends JpaRepository<Operation, String>{
     //this method find all books with our given the name of the author (in our application ManyToMany) not only relations data base
     @Query(value="SELECT o FROM Operation o JOIN o.material m WHERE m.nameMaterial = ?1")
     public Set<Operation> getMaterialsJPQL(String nameMaterial);

}
