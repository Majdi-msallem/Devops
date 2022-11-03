package com.esprit.examen.services;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.CategorieProduitRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CategorieServiceImplTestMockito {
   
	@Mock
	CategorieProduitRepository CatRepo;
	
	@InjectMocks
	CategorieProduitServiceImpl CatSer;
	
	List<Produit> listp = new ArrayList<Produit>() {
		{
		add(Produit.builder().codeProduit("20P").libelleProduit("libP205").prix(56)
		.dateCreation(new Date(2022-10-12)).dateDerniereModification(new Date(2022-10-11))
		.build());
		}
	};
	
	Produit p = Produit.builder().codeProduit("20P").libelleProduit("libP205").prix(56)
			.dateCreation(new Date(2022-10-12)).dateDerniereModification(new Date(2022-10-11))
			.build();
	CategorieProduit C = CategorieProduit.builder().codeCategorie("Code552")
			.libelleCategorie("libelle1112").produits((Set<Produit>) listp).build();
	
	@Test
	public void getCategorie() {
		Mockito.when(CatRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(C));
		CategorieProduit cat = CatSer.retrieveCategorieProduit((long)1);
		assertNotNull(cat);
		log.info("get==>"+cat.toString());
		verify(CatRepo).findById(Mockito.anyLong());
	}
	
	@Test
	public void addCategorieProduit() {
		Mockito.when(CatRepo.save(Mockito.any(CategorieProduit.class))).then(invocation->{
			CategorieProduit cat =invocation.getArgument(0,CategorieProduit.class);
			cat.setIdCategorieProduit(1L);
			cat.setCodeCategorie("cod1");
			cat.setLibelleCategorie("lib1");
			return cat;
		});
	}
	
	@Test
	public void getAllCategories () {
		Mockito.when(CatRepo.findAll()).thenReturn((List<CategorieProduit>) C);
		List<CategorieProduit> cp =CatSer.retrieveAllCategorieProduits();
		assertNotNull(cp);
		for (CategorieProduit categorie : cp) {
			log.info(categorie.toString());
		}
	}
}
