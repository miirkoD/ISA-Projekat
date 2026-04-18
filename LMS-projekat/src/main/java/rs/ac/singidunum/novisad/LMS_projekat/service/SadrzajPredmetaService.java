package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.SadrzajPredmeta;
import rs.ac.singidunum.novisad.LMS_projekat.repository.SadrzajPredmetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SadrzajPredmetaService {

    @Autowired
    private SadrzajPredmetaRepository sadrzajPredmetaRepository;

    public Iterable<SadrzajPredmeta> findAll() {
        return sadrzajPredmetaRepository.findAll();
    }

    public Optional<SadrzajPredmeta> findById(Long id) {
        return sadrzajPredmetaRepository.findById(id);
    }

    public SadrzajPredmeta save(SadrzajPredmeta entity) {
        return sadrzajPredmetaRepository.save(entity);
    }

    public void deleteById(Long id) {
        sadrzajPredmetaRepository.deleteById(id);
    }

}