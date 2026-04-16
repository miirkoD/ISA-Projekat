package rs.ac.singidunum.novisad.LMS_projekat.service;

import rs.ac.singidunum.novisad.LMS_projekat.model.Student;
import rs.ac.singidunum.novisad.LMS_projekat.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    public Student save(Student entity) {
        return studentRepository.save(entity);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }

}
