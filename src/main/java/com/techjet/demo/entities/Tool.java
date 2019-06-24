package com.techjet.demo.entities;

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
//@RequiredArgsConstructor
@Getter
@Setter

@Entity
@Table(name="tool")
public class Tool {
    @Id
    @Column(length = 100)
    @NotNull
    private String nameTool;

//    @ManyToMany
//    @JsonManagedReference
//    private Set<Machine> machine = new HashSet<>();

    @ManyToMany
    @JsonManagedReference
    private Set<AppType> appType = new HashSet<>();

    @OneToOne(mappedBy = "tool", cascade = CascadeType.ALL)
    private Em em;
    @OneToOne(mappedBy = "tool", cascade = CascadeType.ALL)
    private Ebm ebm;
    @OneToOne(mappedBy = "tool", cascade = CascadeType.ALL)
    private Mmem mmem;
    @OneToOne(mappedBy = "tool", cascade = CascadeType.ALL)
    private Pfm pfm;
    @OneToOne(mappedBy = "tool", cascade = CascadeType.ALL)
    private Mmslt mmslt;
    @OneToOne(mappedBy = "tool", cascade = CascadeType.ALL)
    private Slt slt;
    @OneToOne(mappedBy = "tool", cascade = CascadeType.ALL)
    private Rfr rfr;
    @OneToOne(mappedBy = "tool", cascade = CascadeType.ALL)
    private Rfa rfa;
    @OneToOne(mappedBy = "tool", cascade = CascadeType.ALL)
    private Rfarn rfarn;

    @OneToMany(mappedBy = "tool", cascade = CascadeType.ALL)
    private Set<NumTool> numTool = new HashSet<>();


    public Tool(@NotNull String nameTool) {
        this.nameTool = nameTool;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tool tool = (Tool) o;
        return Objects.equals(nameTool, tool.nameTool);
    }


}


