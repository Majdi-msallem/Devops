package com.esprit.examen.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity

@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
@Setter
@RequiredArgsConstructor
public class CategorieProduit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategorieProduit;
	private String codeCategorie;
	private String libelleCategorie;
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "categorieProduit")
	@JsonIgnore
	private Set<Produit> produits;
	public CategorieProduit(String codeCategorie, String libelleCategorie) {
		this.codeCategorie = codeCategorie;
		this.libelleCategorie = libelleCategorie;
	}
	
	
	
	
}
