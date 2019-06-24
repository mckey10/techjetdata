package com.techjet.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name="rootType")
public class RootType {

    @Id
    @Column(length = 100)
    @NotNull
    private String nameRootType;

    @ManyToMany(mappedBy = "rootType", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<AppType> appType = new HashSet<>();

    public RootType(@NotNull String nameRootType) {
        this.nameRootType = nameRootType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RootType rootType = (RootType) o;
        return Objects.equals(nameRootType, rootType.nameRootType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameRootType);
    }
}
