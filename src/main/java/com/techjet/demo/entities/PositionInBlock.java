package com.techjet.demo.entities;

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
@Table(name="positionInBlock")
public class PositionInBlock{

    @Id
    @Column(length=100)
    @NotNull
    private String namePositionInBlock;

    @ManyToMany
    @JsonManagedReference
    private Set<Block> block = new HashSet<>();


    public PositionInBlock(@NotNull String namePositionInBlock) {
        this.namePositionInBlock = namePositionInBlock;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PositionInBlock other = (PositionInBlock) obj;
        if (namePositionInBlock == null) {
            if (other.namePositionInBlock != null)
                return false;
        } else if (!namePositionInBlock.equals(other.namePositionInBlock))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((namePositionInBlock == null) ? 0 : namePositionInBlock.hashCode());
        return result;
    }


}

