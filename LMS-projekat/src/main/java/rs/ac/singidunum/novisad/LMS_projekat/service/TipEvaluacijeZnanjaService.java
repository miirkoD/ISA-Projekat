package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.TipEvaluacijeZnanja;
import rs.ac.singidunum.novisad.LMS_projekat.repository.TipEvaluacijeZnanjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TipEvaluacijeZnanjaService {

    @Autowired
    private TipEvaluacijeZnanjaRepository tipEvaluacijeZnanjaRepository;

    public Iterable<TipEvaluacijeZnanja> findAll() {
        return tipEvaluacijeZnanjaRepository.findAll();
    }

    public Optional<TipEvaluacijeZnanja> findById(Long id) {
        return tipEvaluacijeZnanjaRepository.findById(id);
    }

    public TipEvaluacijeZnanja save(TipEvaluacijeZnanja entity) {
        return tipEvaluacijeZnanjaRepository.save(entity);
    }

    public void deleteById(Long id) {
        tipEvaluacijeZnanjaRepository.deleteById(id);
    }

}