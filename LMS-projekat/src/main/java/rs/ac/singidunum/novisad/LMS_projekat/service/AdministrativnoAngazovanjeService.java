package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.AdministrativnoAngazovanje;
import rs.ac.singidunum.novisad.LMS_projekat.repository.AdministrativnoAngazovanjeRepository;
import rs.ac.singidunum.novisad.LMS_projekat.model.Nastavnik;
import rs.ac.singidunum.novisad.LMS_projekat.service.NastavnikService;
import rs.ac.singidunum.novisad.LMS_projekat.model.StudijskiProgram;
import rs.ac.singidunum.novisad.LMS_projekat.service.StudijskiProgramService;
import rs.ac.singidunum.novisad.LMS_projekat.model.Fakultet;
import rs.ac.singidunum.novisad.LMS_projekat.service.FakultetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AdministrativnoAngazovanjeService {

    @Autowired
    private AdministrativnoAngazovanjeRepository administrativnoAngazovanjeRepository;


    public Iterable<AdministrativnoAngazovanje> findAll() {
        return administrativnoAngazovanjeRepository.findAll();
    }

    public Optional<AdministrativnoAngazovanje> findById(Long id) {
        return administrativnoAngazovanjeRepository.findById(id);
    }

    public AdministrativnoAngazovanje save(AdministrativnoAngazovanje entity) {
        return administrativnoAngazovanjeRepository.save(entity);
    }

    public void deleteById(Long id) {
        administrativnoAngazovanjeRepository.deleteById(id);
    }

}
