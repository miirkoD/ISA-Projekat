package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.Upis;
import rs.ac.singidunum.novisad.LMS_projekat.repository.UpisRepository;
import rs.ac.singidunum.novisad.LMS_projekat.model.GodinaStudija;
import rs.ac.singidunum.novisad.LMS_projekat.service.GodinaStudijaService;
import rs.ac.singidunum.novisad.LMS_projekat.model.SkolskaGodina;
import rs.ac.singidunum.novisad.LMS_projekat.service.SkolskaGodinaService;
import rs.ac.singidunum.novisad.LMS_projekat.model.StudentNaStudijskomProgramu;
import rs.ac.singidunum.novisad.LMS_projekat.service.StudentNaStudijskomProgramuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UpisService {

    @Autowired
    private UpisRepository upisRepository;

    public Iterable<Upis> findAll() {
        return upisRepository.findAll();
    }

    public Optional<Upis> findById(Long id) {
        return upisRepository.findById(id);
    }

    public Upis save(Upis entity) {
        return upisRepository.save(entity);
    }

    public void deleteById(Long id) {
        upisRepository.deleteById(id);
    }

}
