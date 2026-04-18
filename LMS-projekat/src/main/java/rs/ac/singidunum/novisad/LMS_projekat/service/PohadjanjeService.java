package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.Pohadjanje;
import rs.ac.singidunum.novisad.LMS_projekat.repository.PohadjanjeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PohadjanjeService {

    @Autowired
    private PohadjanjeRepository pohadjanjeRepository;

    public Iterable<Pohadjanje> findAll() {
        return pohadjanjeRepository.findAll();
    }

    public Optional<Pohadjanje> findById(Long id) {
        return pohadjanjeRepository.findById(id);
    }

    public Pohadjanje save(Pohadjanje entity) {
        return pohadjanjeRepository.save(entity);
    }

    public void deleteById(Long id) {
        pohadjanjeRepository.deleteById(id);
    }

}