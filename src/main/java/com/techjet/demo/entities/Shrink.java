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
@Table(name="shrink")
public class Shrink {
    @Id
    @Column(length = 100)
    @NotNull
    private String nameShrink;

    @OneToMany(mappedBy = "tool", cascade = CascadeType.ALL)
    private Set<NumTool> numTool = new HashSet<>();

    public Shrink(@NotNull String nameShrink) {
        this.nameShrink = nameShrink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Shrink shrink = (Shrink) o;

        return nameShrink != null ? nameShrink.equals(shrink.nameShrink) : shrink.nameShrink == null;
    }

    @Override
    public int hashCode() {
        return nameShrink != null ? nameShrink.hashCode() : 0;
    }

    public String getNameShrink() {
        return nameShrink;
    }
}
