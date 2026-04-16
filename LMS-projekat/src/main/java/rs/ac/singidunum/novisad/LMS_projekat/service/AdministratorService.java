package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.Administrator;
import rs.ac.singidunum.novisad.LMS_projekat.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepository administratorRepository;

    public Iterable<Administrator> findAll() {
        return administratorRepository.findAll();
    }

    public Optional<Administrator> findById(Long id) {
        return administratorRepository.findById(id);
    }

    public Administrator save(Administrator entity) {
        return administratorRepository.save(entity);
    }

    public void deleteById(Long id) {
        administratorRepository.deleteById(id);
    }

}
