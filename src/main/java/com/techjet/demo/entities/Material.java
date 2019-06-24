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
@Table(name="material")
public class Material {

	@Id
	@Column(length = 100)
	@NotNull
	private String nameMaterial;

	@ManyToMany(mappedBy = "material", cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Operation> operation = new HashSet<>();

	public Material(@NotNull String nameMaterial) {
		this.nameMaterial = nameMaterial;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Material material = (Material) o;

		return nameMaterial != null ? nameMaterial.equals(material.nameMaterial) : material.nameMaterial == null;
	}

	@Override
	public int hashCode() {
		return nameMaterial != null ? nameMaterial.hashCode() : 0;
	}
}




