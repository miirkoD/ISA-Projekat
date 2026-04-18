package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.Predmet;
import rs.ac.singidunum.novisad.LMS_projekat.repository.PredmetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PredmetService {

    @Autowired
    private PredmetRepository predmetRepository;

    public Iterable<Predmet> findAll() {
        return predmetRepository.findAll();
    }

    public Optional<Predmet> findById(Long id) {
        return predmetRepository.findById(id);
    }

    public Predmet save(Predmet entity) {
        return predmetRepository.save(entity);
    }

    public void deleteById(Long id) {
        predmetRepository.deleteById(id);
    }

}