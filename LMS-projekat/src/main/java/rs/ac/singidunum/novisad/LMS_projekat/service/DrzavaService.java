package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.Drzava;
import rs.ac.singidunum.novisad.LMS_projekat.repository.DrzavaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DrzavaService {

    @Autowired
    private DrzavaRepository drzavaRepository;

    public Iterable<Drzava> findAll() {
        return drzavaRepository.findAll();
    }

    public Optional<Drzava> findById(Long id) {
        return drzavaRepository.findById(id);
    }

    public Drzava save(Drzava entity) {
        return drzavaRepository.save(entity);
    }

    public void deleteById(Long id) {
        drzavaRepository.deleteById(id);
    }

}
