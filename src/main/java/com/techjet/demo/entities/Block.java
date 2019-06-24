package com.techjet.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name="block")
public class Block {

    @Id
    @Column(length = 100)
    @NotNull
    private String nameBlock;

    @ManyToMany(mappedBy = "block", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<PositionInBlock> positionInBlock = new HashSet<>();


    @ManyToMany(mappedBy = "block", cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Fixture> fixture = new HashSet<>();

    public Block(@NotNull String nameBlock) {
        this.nameBlock = nameBlock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Block block = (Block) o;

        if (nameBlock != null ? !nameBlock.equals(block.nameBlock) : block.nameBlock != null) return false;
        if (positionInBlock != null ? !positionInBlock.equals(block.positionInBlock) : block.positionInBlock != null)
            return false;
        return fixture != null ? fixture.equals(block.fixture) : block.fixture == null;
    }

    @Override
    public int hashCode() {
        int result = nameBlock != null ? nameBlock.hashCode() : 0;
        result = 31 * result + (positionInBlock != null ? positionInBlock.hashCode() : 0);
        result = 31 * result + (fixture != null ? fixture.hashCode() : 0);
        return result;
    }
}

