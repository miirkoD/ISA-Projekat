package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.SkolskaGodina;
import rs.ac.singidunum.novisad.LMS_projekat.repository.SkolskaGodinaRepository;
import rs.ac.singidunum.novisad.LMS_projekat.model.GodinaStudija;
import rs.ac.singidunum.novisad.LMS_projekat.service.GodinaStudijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SkolskaGodinaService {

    @Autowired
    private SkolskaGodinaRepository skolskaGodinaRepository;


    public Iterable<SkolskaGodina> findAll() {
        return skolskaGodinaRepository.findAll();
    }

    public Optional<SkolskaGodina> findById(Long id) {
        return skolskaGodinaRepository.findById(id);
    }

    public SkolskaGodina save(SkolskaGodina entity) {
        return skolskaGodinaRepository.save(entity);
    }

    public void deleteById(Long id) {
        skolskaGodinaRepository.deleteById(id);
    }

}
