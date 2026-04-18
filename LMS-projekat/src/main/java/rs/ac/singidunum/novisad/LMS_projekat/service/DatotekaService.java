package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.Datoteka;
import rs.ac.singidunum.novisad.LMS_projekat.repository.DatotekaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DatotekaService {

    @Autowired
    private DatotekaRepository datotekaRepository;

    public Iterable<Datoteka> findAll() {
        return datotekaRepository.findAll();
    }

    public Optional<Datoteka> findById(Long id) {
        return datotekaRepository.findById(id);
    }

    public Datoteka save(Datoteka entity) {
        return datotekaRepository.save(entity);
    }

    public void deleteById(Long id) {
        datotekaRepository.deleteById(id);
    }

}
