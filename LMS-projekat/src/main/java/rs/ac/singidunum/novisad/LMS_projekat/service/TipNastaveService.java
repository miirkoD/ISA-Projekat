package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.TipNastave;
import rs.ac.singidunum.novisad.LMS_projekat.repository.TipNastaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TipNastaveService {

    @Autowired
    private TipNastaveRepository tipNastaveRepository;

    public Iterable<TipNastave> findAll() {
        return tipNastaveRepository.findAll();
    }

    public Optional<TipNastave> findById(Long id) {
        return tipNastaveRepository.findById(id);
    }

    public TipNastave save(TipNastave entity) {
        return tipNastaveRepository.save(entity);
    }

    public void deleteById(Long id) {
        tipNastaveRepository.deleteById(id);
    }

}