package odk.g1.penkuru.penkuru.Services;

import lombok.Data;
import odk.g1.penkuru.penkuru.Models.Categorie;
import odk.g1.penkuru.penkuru.Repository.CategorieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class CategorieService {
   CategorieRepository categorieRepository;
   public Categorie creer(Categorie categorie){
       return categorieRepository.save(categorie);
   }
   public List<Categorie>lire(){
       return categorieRepository.findAll();
   }
   public Categorie modifier(Long id,Categorie categorie){
       return categorieRepository.findById(id)
               .map((c)->{
                   c.setNom(c.getNom());
                   c.setVol(c.getVol());
                   return categorieRepository.save(c);
               }).orElseThrow(()->new RuntimeException("categorie introuvable"));
   }
   public String supp(Long id){
       categorieRepository.deleteById(id);
       return "Suppression effectuée";
   }
    
}
