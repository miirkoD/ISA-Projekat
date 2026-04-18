package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.ObrazovniCilj;
import rs.ac.singidunum.novisad.LMS_projekat.repository.ObrazovniCiljRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ObrazovniCiljService {

    @Autowired
    private ObrazovniCiljRepository obrazovniCiljRepository;

    public Iterable<ObrazovniCilj> findAll() {
        return obrazovniCiljRepository.findAll();
    }

    public Optional<ObrazovniCilj> findById(Long id) {
        return obrazovniCiljRepository.findById(id);
    }

    public ObrazovniCilj save(ObrazovniCilj entity) {
        return obrazovniCiljRepository.save(entity);
    }

    public void deleteById(Long id) {
        obrazovniCiljRepository.deleteById(id);
    }

}