package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.Polaganje;
import rs.ac.singidunum.novisad.LMS_projekat.repository.PolaganjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PolaganjeService {

    @Autowired
    private PolaganjeRepository polaganjeRepository;

    public Iterable<Polaganje> findAll() {
        return polaganjeRepository.findAll();
    }

    public Optional<Polaganje> findById(Long id) {
        return polaganjeRepository.findById(id);
    }

    public Polaganje save(Polaganje entity) {
        return polaganjeRepository.save(entity);
    }

    public void deleteById(Long id) {
        polaganjeRepository.deleteById(id);
    }

}