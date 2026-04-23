package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.Univerzitet;
import rs.ac.singidunum.novisad.LMS_projekat.repository.UniverzitetRepository;
import rs.ac.singidunum.novisad.LMS_projekat.model.Adresa;
import rs.ac.singidunum.novisad.LMS_projekat.service.AdresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UniverzitetService {

    @Autowired
    private UniverzitetRepository univerzitetRepository;


    public Iterable<Univerzitet> findAll() {
        return univerzitetRepository.findAll();
    }

    public Optional<Univerzitet> findById(Long id) {
        return univerzitetRepository.findById(id);
    }

    public Univerzitet save(Univerzitet entity) {
        return univerzitetRepository.save(entity);
    }

    public void deleteById(Long id) {
        univerzitetRepository.deleteById(id);
    }

}
