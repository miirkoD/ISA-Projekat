package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.Mesto;
import rs.ac.singidunum.novisad.LMS_projekat.repository.MestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MestoService {

    @Autowired
    private MestoRepository mestoRepository;

  
    public Iterable<Mesto> findAll() {
        return mestoRepository.findAll();
    }

    public Optional<Mesto> findById(Long id) {
        return mestoRepository.findById(id);
    }

    public Mesto save(Mesto entity) {
        return mestoRepository.save(entity);
    }

    public void deleteById(Long id) {
        mestoRepository.deleteById(id);
    }

}
