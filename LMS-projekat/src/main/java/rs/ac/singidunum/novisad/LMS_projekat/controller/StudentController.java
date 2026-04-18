package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.StudentDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Student;
import rs.ac.singidunum.novisad.LMS_projekat.service.StudentService;
import rs.ac.singidunum.novisad.LMS_projekat.model.Adresa;
import rs.ac.singidunum.novisad.LMS_projekat.service.AdresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/studenti")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private AdresaService adresaService;

    private StudentDTO buildDTO(Student e) {
        return new StudentDTO(
          
        );
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ArrayList<StudentDTO> findAll() {
        ArrayList<StudentDTO> list = new ArrayList<>();
        for (Student e : studentService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<StudentDTO> findById(@PathVariable("id") Long id) {
        Optional<Student> opt = studentService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<StudentDTO> deleteById(@PathVariable("id") Long id) {
        Optional<Student> opt = studentService.findById(id);
        if (opt.isPresent()) {
            StudentDTO dto = buildDTO(opt.get());
            studentService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<StudentDTO> create(@RequestBody StudentDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<Adresa> adresaOpt = adresaService.findById(dto.getAdresa().getId());
        if (!adresaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Student entity = new Student(null, adresaOpt.get());
        Student saved = studentService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable("id") Long id, @RequestBody StudentDTO dto) {
        Optional<Student> opt = studentService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Student entity = opt.get();
        Optional<Adresa> adresaOpt = adresaService.findById(dto.getAdresa().getId());
        if (!adresaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setAdresa(adresaOpt.get());
        Student saved = studentService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}
