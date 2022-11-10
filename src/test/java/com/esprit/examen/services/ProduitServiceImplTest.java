package com.esprit.examen.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;


@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest

public class ProduitServiceImplTest {
	
	@Autowired
	ProduitServiceImpl prodServ;
	
	@Autowired
	ProduitRepository prodRepo;
	
	@Autowired
	CategorieProduitServiceImpl catServ;
	
	@Test
	public void testAddProduit(){
		CategorieProduit cat=new CategorieProduit("cat1", "cat2"); 
		CategorieProduit cat1 = catServ.addCategorieProduit(cat);
		Produit pr=new Produit("Prod1", "Prod2");
		pr.setCategorieProduit(cat1);
		Produit p = prodServ.addProduit(pr);
		assertNotNull(p.getIdProduit());
		assertTrue(p.getCodeProduit().length() > 0);
	}

	@Test
	public void testRetrieveAllProduits() {
				
		List<Produit> produits = prodServ.retrieveAllProduits();
		int expected = produits.size();
		Produit pr=new Produit("Prod1", "Prod2");
		Produit p = prodServ.addProduit(pr);
		assertEquals(expected + 1, prodServ.retrieveAllProduits().size());
		prodServ.deleteProduit(p.getIdProduit());;
	}
	
	@Test
	public void testDeleteProduit() {
		Produit pr=new Produit("Prod1", "Prod2");
		Produit p = prodServ.addProduit(pr);
		prodServ.deleteProduit(p.getIdProduit());
		assertNull(prodServ.retrieveProduit(p.getIdProduit()));
	};
	

	@Test
	public void testRetrieveProduit()
	{
		Produit pr=new Produit("Prod1", "Prod2");
		Produit p = prodServ.addProduit(pr);
		Produit produit = prodServ.retrieveProduit(p.getIdProduit());
		assertEquals(p.getIdProduit().longValue(),produit.getIdProduit().longValue());
		
	}
	
	@Test
	public void testUpdateProduit()
	{
		Produit pr=new Produit("Prod1", "Prod2");
		Produit p1 = prodServ.addProduit(pr);
		Produit p = prodServ.retrieveProduit(p1.getIdProduit());
		p.setCodeProduit("test");
		p.setLibelleProduit("tst");
		Produit updatedProduit=prodServ.updateProduit(p);
		assertEquals(p.getLibelleProduit(),updatedProduit.getLibelleProduit());
	}
	
	
}
