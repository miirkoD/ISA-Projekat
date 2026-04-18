package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.EvaluacijaZnanja;
import rs.ac.singidunum.novisad.LMS_projekat.repository.EvaluacijaZnanjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EvaluacijaZnanjaService {

    @Autowired
    private EvaluacijaZnanjaRepository evaluacijaZnanjaRepository;

    public Iterable<EvaluacijaZnanja> findAll() {
        return evaluacijaZnanjaRepository.findAll();
    }

    public Optional<EvaluacijaZnanja> findById(Long id) {
        return evaluacijaZnanjaRepository.findById(id);
    }

    public EvaluacijaZnanja save(EvaluacijaZnanja entity) {
        return evaluacijaZnanjaRepository.save(entity);
    }

    public void deleteById(Long id) {
        evaluacijaZnanjaRepository.deleteById(id);
    }

}