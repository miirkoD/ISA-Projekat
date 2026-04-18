package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.RealizacijaPredmeta;
import rs.ac.singidunum.novisad.LMS_projekat.repository.RealizacijaPredmetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class RealizacijaPredmetaService {

    @Autowired
    private RealizacijaPredmetaRepository realizacijaPredmetaRepository;
    
    public Iterable<RealizacijaPredmeta> findAll() {
        return realizacijaPredmetaRepository.findAll();
    }

    public Optional<RealizacijaPredmeta> findById(Long id) {
        return realizacijaPredmetaRepository.findById(id);
    }

    public RealizacijaPredmeta save(RealizacijaPredmeta entity) {
        return realizacijaPredmetaRepository.save(entity);
    }

    public void deleteById(Long id) {
        realizacijaPredmetaRepository.deleteById(id);
    }

}