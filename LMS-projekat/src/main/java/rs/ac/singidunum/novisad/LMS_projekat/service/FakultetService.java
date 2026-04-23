package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.Fakultet;
import rs.ac.singidunum.novisad.LMS_projekat.repository.FakultetRepository;
import rs.ac.singidunum.novisad.LMS_projekat.model.Univerzitet;
import rs.ac.singidunum.novisad.LMS_projekat.service.UniverzitetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class FakultetService {

    @Autowired
    private FakultetRepository fakultetRepository;

    

    public Iterable<Fakultet> findAll() {
        return fakultetRepository.findAll();
    }

    public Optional<Fakultet> findById(Long id) {
        return fakultetRepository.findById(id);
    }

    public Fakultet save(Fakultet entity) {
        return fakultetRepository.save(entity);
    }

    public void deleteById(Long id) {
        fakultetRepository.deleteById(id);
    }

}
