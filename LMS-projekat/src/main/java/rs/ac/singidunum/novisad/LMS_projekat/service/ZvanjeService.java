package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.Zvanje;
import rs.ac.singidunum.novisad.LMS_projekat.repository.ZvanjeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ZvanjeService {

    @Autowired
    private ZvanjeRepository zvanjeRepository;

    

    public Iterable<Zvanje> findAll() {
        return zvanjeRepository.findAll();
    }

    public Optional<Zvanje> findById(Long id) {
        return zvanjeRepository.findById(id);
    }

    public Zvanje save(Zvanje entity) {
        return zvanjeRepository.save(entity);
    }

    public void deleteById(Long id) {
        zvanjeRepository.deleteById(id);
    }

}
