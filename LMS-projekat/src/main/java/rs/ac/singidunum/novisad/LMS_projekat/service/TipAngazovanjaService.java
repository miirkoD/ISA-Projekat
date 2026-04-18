package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.TipAngazovanja;
import rs.ac.singidunum.novisad.LMS_projekat.repository.TipAngazovanjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TipAngazovanjaService {

    @Autowired
    private TipAngazovanjaRepository tipAngazovanjaRepository;

    public Iterable<TipAngazovanja> findAll() {
        return tipAngazovanjaRepository.findAll();
    }

    public Optional<TipAngazovanja> findById(Long id) {
        return tipAngazovanjaRepository.findById(id);
    }

    public TipAngazovanja save(TipAngazovanja entity) {
        return tipAngazovanjaRepository.save(entity);
    }

    public void deleteById(Long id) {
        tipAngazovanjaRepository.deleteById(id);
    }

}