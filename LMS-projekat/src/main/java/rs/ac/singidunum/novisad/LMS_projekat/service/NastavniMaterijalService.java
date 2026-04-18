package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.NastavniMaterijal;
import rs.ac.singidunum.novisad.LMS_projekat.repository.NastavniMaterijalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class NastavniMaterijalService {

    @Autowired
    private NastavniMaterijalRepository nastavniMaterijalRepository;

    public Iterable<NastavniMaterijal> findAll() {
        return nastavniMaterijalRepository.findAll();
    }

    public Optional<NastavniMaterijal> findById(Long id) {
        return nastavniMaterijalRepository.findById(id);
    }

    public NastavniMaterijal save(NastavniMaterijal entity) {
        return nastavniMaterijalRepository.save(entity);
    }

    public void deleteById(Long id) {
        nastavniMaterijalRepository.deleteById(id);
    }

}