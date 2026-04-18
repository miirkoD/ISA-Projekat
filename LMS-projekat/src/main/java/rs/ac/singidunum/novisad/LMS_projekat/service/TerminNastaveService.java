package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.TerminNastave;
import rs.ac.singidunum.novisad.LMS_projekat.repository.TerminNastaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TerminNastaveService {

    @Autowired
    private TerminNastaveRepository terminNastaveRepository;

    public Iterable<TerminNastave> findAll() {
        return terminNastaveRepository.findAll();
    }

    public Optional<TerminNastave> findById(Long id) {
        return terminNastaveRepository.findById(id);
    }

    public TerminNastave save(TerminNastave entity) {
        return terminNastaveRepository.save(entity);
    }

    public void deleteById(Long id) {
        terminNastaveRepository.deleteById(id);
    }

}