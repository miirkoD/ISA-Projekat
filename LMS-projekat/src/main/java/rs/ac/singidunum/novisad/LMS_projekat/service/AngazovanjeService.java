package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.Angazovanje;
import rs.ac.singidunum.novisad.LMS_projekat.repository.AngazovanjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AngazovanjeService {

    @Autowired
    private AngazovanjeRepository angazovanjeRepository;

    public Iterable<Angazovanje> findAll() {
        return angazovanjeRepository.findAll();
    }

    public Optional<Angazovanje> findById(Long id) {
        return angazovanjeRepository.findById(id);
    }

    public Angazovanje save(Angazovanje entity) {
        return angazovanjeRepository.save(entity);
    }

    public void deleteById(Long id) {
        angazovanjeRepository.deleteById(id);
    }

}