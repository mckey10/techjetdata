package com.techjet.demo.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name="operation")
public class Operation {

    @Id
    @Column(length=100)
    @NotNull
    private String nameOperation;

    @ManyToMany
    @JsonManagedReference
    private Set<Material> material = new HashSet<>();

    @ManyToMany(mappedBy = "operation", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Machine> machine = new HashSet<>();

    public Operation(@NotNull String nameOperation) {
        this.nameOperation = nameOperation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operation operation = (Operation) o;

        return nameOperation != null ? nameOperation.equals(operation.nameOperation) : operation.nameOperation == null;
    }

    @Override
    public int hashCode() {
        return nameOperation != null ? nameOperation.hashCode() : 0;
    }
}

