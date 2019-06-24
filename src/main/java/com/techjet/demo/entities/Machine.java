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
@Table(name="machine")
public class Machine {
    @Id
    @Column(length=100)
    @NotNull
    private String nameMachine;

    @ManyToMany
    @JsonManagedReference
    private Set<Operation> operation = new HashSet<>();

    @ManyToMany
    @JsonManagedReference
    private Set<Fixture> fixture = new HashSet<>();

//    @ManyToMany(mappedBy = "machine", cascade = CascadeType.ALL)
//    @JsonBackReference
//    private Set<Tool> tool = new HashSet<>();

    @ManyToMany
    @JsonManagedReference
    private Set<NumTool> numTool = new HashSet<>();

    public Machine(@NotNull String nameMachine) {
        this.nameMachine = nameMachine;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Machine other = (Machine) obj;
        if (nameMachine == null) {
            if (other.nameMachine != null)
                return false;
        } else if (!nameMachine.equals(other.nameMachine))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nameMachine == null) ? 0 : nameMachine.hashCode());
        return result;
    }

}
