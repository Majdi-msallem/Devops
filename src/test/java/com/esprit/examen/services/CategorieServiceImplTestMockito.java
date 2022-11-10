/*
 * package com.esprit.examen.services;
 * 
* import static org.junit.jupiter.api.Assertions.assertEquals; import static
 * org.junit.jupiter.api.Assertions.assertNotNull; import static
 * org.mockito.ArgumentMatchers.any; import static
 * org.mockito.Mockito.doNothing; import static org.mockito.Mockito.times;
 * import static org.mockito.Mockito.verify;
 * 
 * import java.util.ArrayList; import java.util.List; import java.util.Optional;
 * 
 * import org.junit.Test; import org.junit.jupiter.api.extension.ExtendWith;
 * import org.mockito.InjectMocks; import org.mockito.Mock; import
 * org.mockito.Mockito; import org.mockito.junit.jupiter.MockitoExtension;
 * import org.springframework.boot.test.context.SpringBootTest;
 * 
 * import com.esprit.examen.entities.CategorieProduit; import
 * com.esprit.examen.repositories.CategorieProduitRepository;
 * 
 * import lombok.extern.slf4j.Slf4j;
 * 
 * @ExtendWith(MockitoExtension.class)
 * 
 * @SpringBootTest public class CategorieServiceImplTestMockito {
 * 
 * @Mock CategorieProduitRepository catRepo ;
 * 
 * 
 * @InjectMocks CategorieProduitServiceImpl is;
 * 
 * CategorieProduit cat = new CategorieProduit("CODE","LIBELLE");
 * 
 * List<CategorieProduit> list = new ArrayList<CategorieProduit> () { { add(new
 * CategorieProduit("Code","Libelle")); add(new
 * CategorieProduit("Code","Libelle"));
 * 
 * } };
 * 
 * @Test public void testRetrieveAllCategorieProduits() {
 * Mockito.when(catRepo.findAll()).thenReturn(list); assertEquals(list.size(),
 * is.retrieveAllCategorieProduits().size()); }
 * 
 * 
 * @Test public void testAddCategorieProduit() { CategorieProduit cat = new
 * CategorieProduit("CODE","LIBELLE");
 * Mockito.when(catRepo.save(any(CategorieProduit.class))).thenReturn(cat);
 * CategorieProduit catP = is.addCategorieProduit(cat); assertNotNull(catP);
 * 
 * }
 * 
 * @Test public void testRetrieveCategorieProduit() {
 * 
 * Mockito.when(catRepo.findById(Mockito.anyLong())).thenReturn(Optional.of(cat)
 * ); CategorieProduit cat = is.retrieveCategorieProduit(2L);
 * assertNotNull(cat);
 * 
 * }
 * 
 * @Test public void testUpdateCategorieProduit() { CategorieProduit cat = new
 * CategorieProduit("CODE","LIBELLE");
 * Mockito.when(catRepo.save(any(CategorieProduit.class))).thenReturn(cat);
 * cat.setCodeCategorie("CodeUpdated");
 * cat.setLibelleCategorie("LibelleUpdated"); CategorieProduit catUpdated =
 * is.updateCategorieProduit(cat); assertNotNull(catUpdated);
 * assertEquals(cat.getLibelleCategorie(),catUpdated.getLibelleCategorie());
 * 
 * }
 * 
 * @Test public void testDeleteCategorieProduit() { CategorieProduit cat = new
 * CategorieProduit("CODE","LIBELLE"); cat.setIdCategorieProduit(1L);
 * doNothing().when(catRepo).deleteById(Mockito.anyLong());
 * is.deleteCategorieProduit(1L);
 * verify(catRepo,times(1)).deleteById(cat.getIdCategorieProduit()); } }
 */