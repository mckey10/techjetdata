package com.techjet.demo.entities;

import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
//@Getter
@Setter

@Entity
@Table(name="strshank")
public class Strshank {
    @Id
    @Column(length = 100)
    @NotNull
    private String nameStrshank;

    @OneToMany(mappedBy = "tool", cascade = CascadeType.ALL)
    private Set<NumTool> numTool = new HashSet<>();

    public Strshank(@NotNull String nameStrshank) {
        this.nameStrshank = nameStrshank;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Strshank strshank = (Strshank) o;

        return nameStrshank != null ? nameStrshank.equals(strshank.nameStrshank) : strshank.nameStrshank == null;
    }

    @Override
    public int hashCode() {
        return nameStrshank != null ? nameStrshank.hashCode() : 0;
    }

    public String getNameStrshank() {
        return nameStrshank;
    }
}
