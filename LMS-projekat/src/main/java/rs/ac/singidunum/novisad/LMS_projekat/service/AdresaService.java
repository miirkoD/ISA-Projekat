package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.Adresa;
import rs.ac.singidunum.novisad.LMS_projekat.repository.AdresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AdresaService {

    @Autowired
    private AdresaRepository adresaRepository;


    public Iterable<Adresa> findAll() {
        return adresaRepository.findAll();
    }

    public Optional<Adresa> findById(Long id) {
        return adresaRepository.findById(id);
    }

    public Adresa save(Adresa entity) {
        return adresaRepository.save(entity);
    }

    public void deleteById(Long id) {
        adresaRepository.deleteById(id);
    }

}
