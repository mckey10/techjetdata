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
@Table(name="mmaster")
public class Mmaster {
    @Id
    @Column(length = 100)
    @NotNull
    private String nameMmaster;

    @OneToMany(mappedBy = "tool", cascade = CascadeType.ALL)
    private Set<NumTool> numTool = new HashSet<>();


    public Mmaster(@NotNull String nameMmaster) {
        this.nameMmaster = nameMmaster;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mmaster mmaster = (Mmaster) o;
        return Objects.equals(nameMmaster, mmaster.nameMmaster);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameMmaster);
    }

    public String getNameMmaster() {
        return nameMmaster;
    }
}
