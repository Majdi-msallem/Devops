package com.esprit.examen.services;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.esprit.examen.entities.Produit;
import com.esprit.examen.repositories.ProduitRepository;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@Slf4j
public class ProduitServiceImplTest {
	
	@Autowired
	ProduitRepository pr;
	
	Produit p = Produit.builder().codeProduit("cp").prix(30).dateCreation(new Date(2022-10-14)) 
			.dateDerniereModification(new Date(2022-10-15)).libelleProduit("libp1").build();
	
	@Test
	@Order(0)
	public void ajouterProduit() {
		p= pr.save(p);
		log.info(p.toString());
		Assertions.assertNotNull(p.getIdProduit());
	}

	
	@Test
	@Order(1)
	public void modifierProduit() {
		p.setCodeProduit("cp1Up");
		p.setDateDerniereModification(new Date(2022-10-21));
		p.setLibelleProduit("libp1Up");
		p.setPrix(21);
		p= pr.save(p);
		log.info(p.toString());
		
	}
	
	@Test
	@Order(2)
	public void ListProduit() {
		List<Produit> list=pr.findAll();
		log.info(list.size()+"");
		Assertions.assertTrue(list.size()>0);
	}
	
	@Test
	@Order(3)
	public void DeleteProduit() {
		log.info("Produit"+p);
		log.info("ID de Produit a supprime"+ p.getIdProduit());
		pr.delete(p);
	}
	
	
}
