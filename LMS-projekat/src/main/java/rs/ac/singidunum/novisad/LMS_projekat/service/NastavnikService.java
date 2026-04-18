package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.Nastavnik;
import rs.ac.singidunum.novisad.LMS_projekat.repository.NastavnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class NastavnikService {

    @Autowired
    private NastavnikRepository nastavnikRepository;

    public Iterable<Nastavnik> findAll() {
        return nastavnikRepository.findAll();
    }

    public Optional<Nastavnik> findById(Long id) {
        return nastavnikRepository.findById(id);
    }

    public Nastavnik save(Nastavnik entity) {
        return nastavnikRepository.save(entity);
    }

    public void deleteById(Long id) {
        nastavnikRepository.deleteById(id);
    }

}
