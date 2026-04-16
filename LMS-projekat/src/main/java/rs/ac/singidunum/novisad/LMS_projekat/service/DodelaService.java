package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.Dodela;
import rs.ac.singidunum.novisad.LMS_projekat.repository.DodelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DodelaService {

    @Autowired
    private DodelaRepository dodelaRepository;

    
    public Iterable<Dodela> findAll() {
        return dodelaRepository.findAll();
    }

    public Optional<Dodela> findById(Long id) {
        return dodelaRepository.findById(id);
    }

    public Dodela save(Dodela entity) {
        return dodelaRepository.save(entity);
    }

    public void deleteById(Long id) {
        dodelaRepository.deleteById(id);
    }

}
