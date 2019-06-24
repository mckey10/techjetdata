package com.techjet.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name="appType")
public class AppType {

    @Id
    @Column(length = 100)
    @NotNull
    private String nameAppType;

    @ManyToMany
    @JsonManagedReference
    private Set<RootType> rootType = new HashSet<>();


    @ManyToMany(mappedBy = "appType", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Tool> tool = new HashSet<>();

    public AppType(@NotNull String nameAppType) {
        this.nameAppType = nameAppType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AppType appType = (AppType) o;
        return Objects.equals(nameAppType, appType.nameAppType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameAppType);
    }
}
