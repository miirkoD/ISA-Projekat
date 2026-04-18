package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.TipNastavnogMaterijala;
import rs.ac.singidunum.novisad.LMS_projekat.repository.TipNastavnogMaterijalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TipNastavnogMaterijalaService {

    @Autowired
    private TipNastavnogMaterijalaRepository tipNastavnogMaterijalaRepository;

    public Iterable<TipNastavnogMaterijala> findAll() {
        return tipNastavnogMaterijalaRepository.findAll();
    }

    public Optional<TipNastavnogMaterijala> findById(Long id) {
        return tipNastavnogMaterijalaRepository.findById(id);
    }

    public TipNastavnogMaterijala save(TipNastavnogMaterijala entity) {
        return tipNastavnogMaterijalaRepository.save(entity);
    }

    public void deleteById(Long id) {
        tipNastavnogMaterijalaRepository.deleteById(id);
    }

}