package com.techjet.demo.entities;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@NoArgsConstructor
//@Getter
@Setter

@Entity
@Table(name="collet")
public class Collet {
    @Id
    @Column(length = 100)
    @NotNull
    private String nameCollet;

    @OneToMany(mappedBy = "tool", cascade = CascadeType.ALL)
    private Set<NumTool> numTool = new HashSet<>();

    public Collet(@NotNull String nameCollet) {
        this.nameCollet = nameCollet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Collet collet = (Collet) o;
        return Objects.equals(nameCollet, collet.nameCollet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameCollet);
    }

    public String getNameCollet() {
        return nameCollet;
    }
}
