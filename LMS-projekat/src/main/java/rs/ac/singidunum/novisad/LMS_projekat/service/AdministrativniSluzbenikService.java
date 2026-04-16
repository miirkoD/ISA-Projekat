package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.AdministrativniSluzbenik;
import rs.ac.singidunum.novisad.LMS_projekat.repository.AdministrativniSluzbenikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AdministrativniSluzbenikService {

    @Autowired
    private AdministrativniSluzbenikRepository administrativniSluzbenikRepository;

    public Iterable<AdministrativniSluzbenik> findAll() {
        return administrativniSluzbenikRepository.findAll();
    }

    public Optional<AdministrativniSluzbenik> findById(Long id) {
        return administrativniSluzbenikRepository.findById(id);
    }

    public AdministrativniSluzbenik save(AdministrativniSluzbenik entity) {
        return administrativniSluzbenikRepository.save(entity);
    }

    public void deleteById(Long id) {
        administrativniSluzbenikRepository.deleteById(id);
    }

}
