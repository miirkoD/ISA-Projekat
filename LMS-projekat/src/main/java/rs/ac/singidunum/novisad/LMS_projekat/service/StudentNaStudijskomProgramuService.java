package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.StudentNaStudijskomProgramu;
import rs.ac.singidunum.novisad.LMS_projekat.repository.StudentNaStudijskomProgramuRepository;
import rs.ac.singidunum.novisad.LMS_projekat.model.Student;
import rs.ac.singidunum.novisad.LMS_projekat.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class StudentNaStudijskomProgramuService {

    @Autowired
    private StudentNaStudijskomProgramuRepository studentNaStudijskomProgramuRepository;

    

    public Iterable<StudentNaStudijskomProgramu> findAll() {
        return studentNaStudijskomProgramuRepository.findAll();
    }

    public Optional<StudentNaStudijskomProgramu> findById(Long id) {
        return studentNaStudijskomProgramuRepository.findById(id);
    }

    public StudentNaStudijskomProgramu save(StudentNaStudijskomProgramu entity) {
        return studentNaStudijskomProgramuRepository.save(entity);
    }

    public void deleteById(Long id) {
        studentNaStudijskomProgramuRepository.deleteById(id);
    }

}
