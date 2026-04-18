package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.PravoPristupa;
import rs.ac.singidunum.novisad.LMS_projekat.repository.PravoPristupaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class PravoPristupaService {

    @Autowired
    private PravoPristupaRepository pravoPristupaRepository;


    public Iterable<PravoPristupa> findAll() {
        return pravoPristupaRepository.findAll();
    }

    public Optional<PravoPristupa> findById(Long id) {
        return pravoPristupaRepository.findById(id);
    }

    public PravoPristupa save(PravoPristupa entity) {
        return pravoPristupaRepository.save(entity);
    }

    public void deleteById(Long id) {
        pravoPristupaRepository.deleteById(id);
    }

}
