package com.techjet.demo.entities;

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
@Table(name="holder")
public class Holder {
    @Id
    @Column(length = 100)
    @NotNull
    private String nameHolder;

    @OneToMany(mappedBy = "tool", cascade = CascadeType.ALL)
    private Set<NumTool> numTool = new HashSet<>();


    public Holder(@NotNull String nameHolder) {
        this.nameHolder = nameHolder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Holder holder = (Holder) o;
        return Objects.equals(nameHolder, holder.nameHolder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameHolder);
    }
}
