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
@Table(name="numTool")
public class NumTool {
    @Id
    @Column(length = 100)
    @NotNull
    private String nameNumTool;

    private int length;

    @ManyToMany(mappedBy = "numTool", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Machine> machine = new HashSet<>();

    @ManyToOne
    private Tool tool;
    @ManyToOne
    private Holder holder;
    @ManyToOne
    private Mmaster mmaster;
    @ManyToOne
    private Collet collet;
    @ManyToOne
    private Shrink shrink;
    @ManyToOne
    private Strshank strshank;


    public NumTool(@NotNull String nameNumTool, int length) {
        this.nameNumTool = nameNumTool;
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumTool numTool = (NumTool) o;
        return length == numTool.length &&
                Objects.equals(nameNumTool, numTool.nameNumTool);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameNumTool, length);
    }

}

