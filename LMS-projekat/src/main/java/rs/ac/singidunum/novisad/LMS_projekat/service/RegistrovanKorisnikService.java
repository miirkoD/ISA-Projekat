package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.RegistrovanKorisnik;
import rs.ac.singidunum.novisad.LMS_projekat.repository.RegistrovanKorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class RegistrovanKorisnikService {

    @Autowired
    private RegistrovanKorisnikRepository registrovanKorisnikRepository;

    public Iterable<RegistrovanKorisnik> findAll() {
        return registrovanKorisnikRepository.findAll();
    }

    public Optional<RegistrovanKorisnik> findById(Long id) {
        return registrovanKorisnikRepository.findById(id);
    }

    public RegistrovanKorisnik save(RegistrovanKorisnik entity) {
        return registrovanKorisnikRepository.save(entity);
    }

    public void deleteById(Long id) {
        registrovanKorisnikRepository.deleteById(id);
    }

}
