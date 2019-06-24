package com.techjet.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name="fixture")
public class Fixture {
    @Id
    @Column(length=100)
    @NotNull
    private String nameFixture;

    @ManyToMany
    @JsonManagedReference
    private Set<Block> block = new HashSet<>();

	@ManyToMany(mappedBy = "fixture", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Machine> machine = new HashSet<>();

    public Fixture(@NotNull String nameFixture) {
		this.nameFixture = nameFixture;
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fixture other = (Fixture) obj;
		if (nameFixture == null) {
			if (other.nameFixture != null)
				return false;
		} else if (!nameFixture.equals(other.nameFixture))
			return false;
		return true;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nameFixture == null) ? 0 : nameFixture.hashCode());
		return result;
	}
	

}

