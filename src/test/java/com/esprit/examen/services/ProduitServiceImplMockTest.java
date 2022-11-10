package com.esprit.examen.services;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.CategorieProduitRepository;
import com.esprit.examen.repositories.ProduitRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ProduitServiceImplMockTest {

	
	@Mock
	ProduitRepository prodRepo ; 
	
	@Mock
	CategorieProduitRepository catRepo ; 
	
	@InjectMocks
	ProduitServiceImpl prodServ;
	
	@InjectMocks
	CategorieProduitServiceImpl catServ;
	
	Produit p = new Produit("Code","Libelle");
	
	List<Produit> list = new ArrayList<Produit> () {
		{
			add(new Produit("Code","Libelle"));
			add(new Produit("Code","Libelle"));
			
		}
	};
	
	@Test  
	public void testRetrieveAllProduits() {
		Mockito.when(prodRepo.findAll()).thenReturn(list);
		assertEquals(list.size(), prodServ.retrieveAllProduits().size());
	}

	
	@Test 
	public void testAddProduit() {
		CategorieProduit cat=new CategorieProduit("cat1", "cat2"); 
		Mockito.when(prodRepo.save(any(Produit.class))).thenReturn(p);
		Mockito.when(catRepo.save(any(CategorieProduit.class))).thenReturn(cat);
		CategorieProduit cat1 = catServ.addCategorieProduit(cat);
		Produit f1 = prodServ.addProduit(p);
		assertNotNull(f1);
		assertTrue(p.getCodeProduit().length() > 0);
		
	}
	
	@Test 
	public void testRetrieveProduit() {
		
		Mockito.when(prodRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(p) );	
		Produit f = prodServ.retrieveProduit(2L);
		assertNotNull(f);
		
	}
	
	@Test 
	public void testUpdateProduit() {
		Produit p = new Produit("CODE","LIBELEL");
		System.out.println("++++++PRODUIT++++++++++"+p);
		Mockito.when(prodRepo.save(any(Produit.class))).thenReturn(p);	
		p.setCodeProduit("CodeProduit");
		p.setLibelleProduit("LibelleProduit");
		System.out.println("++++UPDATE++++"+p);
		Produit pUpdated = prodServ.updateProduit(p);
		assertNotNull(pUpdated);
		assertEquals(p.getLibelleProduit(),pUpdated.getLibelleProduit());

	}
	
	@Test 
	public void testDeleteProduit() {
		Produit p = new Produit("CODE","LIBELEL");
		p.setIdProduit(1L);	
		doNothing().when(prodRepo).deleteById(Mockito.anyLong());
		prodServ.deleteProduit(1L);
		verify(prodRepo,times(1)).deleteById(p.getIdProduit());
	}
}
