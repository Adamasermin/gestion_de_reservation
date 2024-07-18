package odk.g1.penkuru.penkuru.Services;

import odk.g1.penkuru.penkuru.Models.Pays;
import odk.g1.penkuru.penkuru.Repository.PaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaysService {
    @Autowired
    private PaysRepository paysRepository;
    //recupere tous les pays
    public List<Pays> getAllPays() {
        return paysRepository.findAll();
    }
    // pour recuperer un pays par son id
    public Pays getPayByID(Long id) {
        Optional<Pays> pays = paysRepository.findById(id);
        return pays.orElse(null);
    }
    // creer un nouveau pays
    public Pays savePays(Pays pays) {
        return paysRepository.save(pays);
    }
    //mise  a jour
    public Pays updatePays(Long id, Pays pays) {
        Optional<Pays> paysOptional = paysRepository.findById(id);
        if (paysOptional.isPresent()) {
            pays.setId(id);
            return paysRepository.save(pays);
        }
        return null;
    }
    //supprimer un pays
    public void deletePays(Long id) {
        paysRepository.deleteById(id);
    }
    
}
