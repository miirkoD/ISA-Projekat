package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.InstrumentEvaluacijeZnanja;
import rs.ac.singidunum.novisad.LMS_projekat.repository.InstrumentEvaluacijeZnanjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class InstrumentEvaluacijeZnanjaService {

    @Autowired
    private InstrumentEvaluacijeZnanjaRepository instrumentEvaluacijeZnanjaRepository;

    public Iterable<InstrumentEvaluacijeZnanja> findAll() {
        return instrumentEvaluacijeZnanjaRepository.findAll();
    }

    public Optional<InstrumentEvaluacijeZnanja> findById(Long id) {
        return instrumentEvaluacijeZnanjaRepository.findById(id);
    }

    public InstrumentEvaluacijeZnanja save(InstrumentEvaluacijeZnanja entity) {
        return instrumentEvaluacijeZnanjaRepository.save(entity);
    }

    public void deleteById(Long id) {
        instrumentEvaluacijeZnanjaRepository.deleteById(id);
    }

}