package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.NaucnaOblast;
import rs.ac.singidunum.novisad.LMS_projekat.repository.NaucnaOblastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class NaucnaOblastService {

    @Autowired
    private NaucnaOblastRepository naucnaOblastRepository;

    public Iterable<NaucnaOblast> findAll() {
        return naucnaOblastRepository.findAll();
    }

    public Optional<NaucnaOblast> findById(Long id) {
        return naucnaOblastRepository.findById(id);
    }

    public NaucnaOblast save(NaucnaOblast entity) {
        return naucnaOblastRepository.save(entity);
    }

    public void deleteById(Long id) {
        naucnaOblastRepository.deleteById(id);
    }

}
