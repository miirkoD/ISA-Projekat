package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.Ishod;
import rs.ac.singidunum.novisad.LMS_projekat.repository.IshodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class IshodService {

    @Autowired
    private IshodRepository ishodRepository;

    public Iterable<Ishod> findAll() {
        return ishodRepository.findAll();
    }

    public Optional<Ishod> findById(Long id) {
        return ishodRepository.findById(id);
    }

    public Ishod save(Ishod entity) {
        return ishodRepository.save(entity);
    }

    public void deleteById(Long id) {
        ishodRepository.deleteById(id);
    }

}