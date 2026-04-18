package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.TipZvanja;
import rs.ac.singidunum.novisad.LMS_projekat.repository.TipZvanjaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TipZvanjaService {

    @Autowired
    private TipZvanjaRepository tipZvanjaRepository;

    public Iterable<TipZvanja> findAll() {
        return tipZvanjaRepository.findAll();
    }

    public Optional<TipZvanja> findById(Long id) {
        return tipZvanjaRepository.findById(id);
    }

    public TipZvanja save(TipZvanja entity) {
        return tipZvanjaRepository.save(entity);
    }

    public void deleteById(Long id) {
        tipZvanjaRepository.deleteById(id);
    }

}
