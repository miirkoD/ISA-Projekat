package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.StudentNaStudijskomProgramuDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.StudentNaStudijskomProgramu;
import rs.ac.singidunum.novisad.LMS_projekat.service.StudentNaStudijskomProgramuService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.StudentDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Student;
import rs.ac.singidunum.novisad.LMS_projekat.service.StudentService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.PohadjanjeDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Pohadjanje;
import rs.ac.singidunum.novisad.LMS_projekat.dto.PolaganjeDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Polaganje;
import rs.ac.singidunum.novisad.LMS_projekat.dto.UpisDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Upis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/studentiNaStudijskimProgramima")
public class StudentNaStudijskomProgramuController {

    @Autowired
    private StudentNaStudijskomProgramuService studentNaStudijskomProgramuService;

    @Autowired
    private StudentService studentService;

    private StudentNaStudijskomProgramuDTO buildDTO(StudentNaStudijskomProgramu e) {
        StudentDTO studentDTO = new StudentDTO(
            e.getStudent().getId()
        );
        List<PohadjanjeDTO> pohadjanjaDTOList = new ArrayList<>();
        for (Pohadjanje item : e.getPohadjanja()) {
            pohadjanjaDTOList.add(new PohadjanjeDTO(
                item.getId(),
                item.getKonacnaOcena()
            ));
        }
        List<PolaganjeDTO> polaganjaDTOList = new ArrayList<>();
        for (Polaganje item : e.getPolaganja()) {
            polaganjaDTOList.add(new PolaganjeDTO(
                item.getId(),
                item.getBodovi(),
                item.getNapomena()
            ));
        }
        List<UpisDTO> upisiDTOList = new ArrayList<>();
        for (Upis item : e.getUpisi()) {
            upisiDTOList.add(new UpisDTO(
                item.getId(),
                item.getBrojUpisa()
            ));
        }
        return new StudentNaStudijskomProgramuDTO(
            e.getId(),
            e.getBrojIndeksa(),
            studentDTO,
            pohadjanjaDTOList,
            polaganjaDTOList,
            upisiDTOList
        );
    }

    @RequestMapping(path = "", method = org.springframework.web.bind.annotation.RequestMethod.GET)
    public ArrayList<StudentNaStudijskomProgramuDTO> findAll() {
        ArrayList<StudentNaStudijskomProgramuDTO> list = new ArrayList<>();
        for (StudentNaStudijskomProgramu e : studentNaStudijskomProgramuService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<StudentNaStudijskomProgramuDTO> findById(@PathVariable("id") Long id) {
        Optional<StudentNaStudijskomProgramu> opt = studentNaStudijskomProgramuService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<StudentNaStudijskomProgramuDTO> deleteById(@PathVariable("id") Long id) {
        Optional<StudentNaStudijskomProgramu> opt = studentNaStudijskomProgramuService.findById(id);
        if (opt.isPresent()) {
            StudentNaStudijskomProgramuDTO dto = buildDTO(opt.get());
            studentNaStudijskomProgramuService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<StudentNaStudijskomProgramuDTO> create(@RequestBody StudentNaStudijskomProgramuDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<Student> studentOpt = studentService.findById(dto.getStudent().getId());
        if (!studentOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        StudentNaStudijskomProgramu entity = new StudentNaStudijskomProgramu(null, dto.getBrojIndeksa(), studentOpt.get());
        StudentNaStudijskomProgramu saved = studentNaStudijskomProgramuService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<StudentNaStudijskomProgramuDTO> update(@PathVariable("id") Long id, @RequestBody StudentNaStudijskomProgramuDTO dto) {
        Optional<StudentNaStudijskomProgramu> opt = studentNaStudijskomProgramuService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        StudentNaStudijskomProgramu entity = opt.get();
        entity.setBrojIndeksa(dto.getBrojIndeksa());
        Optional<Student> studentOpt = studentService.findById(dto.getStudent().getId());
        if (!studentOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setStudent(studentOpt.get());
        StudentNaStudijskomProgramu saved = studentNaStudijskomProgramuService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}
