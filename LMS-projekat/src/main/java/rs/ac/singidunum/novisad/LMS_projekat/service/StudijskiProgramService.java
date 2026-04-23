package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.StudijskiProgram;
import rs.ac.singidunum.novisad.LMS_projekat.repository.StudijskiProgramRepository;
import rs.ac.singidunum.novisad.LMS_projekat.model.Fakultet;
import rs.ac.singidunum.novisad.LMS_projekat.service.FakultetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class StudijskiProgramService {

    @Autowired
    private StudijskiProgramRepository studijskiProgramRepository;


    public Iterable<StudijskiProgram> findAll() {
        return studijskiProgramRepository.findAll();
    }

    public Optional<StudijskiProgram> findById(Long id) {
        return studijskiProgramRepository.findById(id);
    }

    public StudijskiProgram save(StudijskiProgram entity) {
        return studijskiProgramRepository.save(entity);
    }

    public void deleteById(Long id) {
        studijskiProgramRepository.deleteById(id);
    }

}
