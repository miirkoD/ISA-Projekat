package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.GodinaStudija;
import rs.ac.singidunum.novisad.LMS_projekat.repository.GodinaStudijaRepository;
import rs.ac.singidunum.novisad.LMS_projekat.model.StudijskiProgram;
import rs.ac.singidunum.novisad.LMS_projekat.service.StudijskiProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class GodinaStudijaService {

    @Autowired
    private GodinaStudijaRepository godinaStudijaRepository;


    public Iterable<GodinaStudija> findAll() {
        return godinaStudijaRepository.findAll();
    }

    public Optional<GodinaStudija> findById(Long id) {
        return godinaStudijaRepository.findById(id);
    }

    public GodinaStudija save(GodinaStudija entity) {
        return godinaStudijaRepository.save(entity);
    }

    public void deleteById(Long id) {
        godinaStudijaRepository.deleteById(id);
    }

}
