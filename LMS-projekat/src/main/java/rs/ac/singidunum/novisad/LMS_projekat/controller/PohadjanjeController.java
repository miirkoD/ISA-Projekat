package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.PohadjanjeDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.RealizacijaPredmetaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.StudentNaStudijskomProgramuDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Pohadjanje;
import rs.ac.singidunum.novisad.LMS_projekat.model.RealizacijaPredmeta;
import rs.ac.singidunum.novisad.LMS_projekat.model.StudentNaStudijskomProgramu;
import rs.ac.singidunum.novisad.LMS_projekat.service.PohadjanjeService;
import rs.ac.singidunum.novisad.LMS_projekat.service.RealizacijaPredmetaService;
import rs.ac.singidunum.novisad.LMS_projekat.service.StudentNaStudijskomProgramuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/pohadjanja")
public class PohadjanjeController {

    @Autowired
    private PohadjanjeService pohadjanjeService;

    @Autowired
    private StudentNaStudijskomProgramuService studentNaStudijskomProgramuService;
    
    @Autowired
    private RealizacijaPredmetaService realizacijaPredmetaService;

    private PohadjanjeDTO buildDTO(Pohadjanje e) {
        StudentNaStudijskomProgramuDTO studentiNaStudijskimProgramimaDTO = new StudentNaStudijskomProgramuDTO(
            e.getStudentiNaStudijskimProgramima().getId(),
            e.getStudentiNaStudijskimProgramima().getBrojIndeksa()
        );
        RealizacijaPredmetaDTO realizacijaPredmetaDTO = new RealizacijaPredmetaDTO(
            e.getRealizacijaPredmeta().getId()
        );
        return new PohadjanjeDTO(
            e.getId(),
            e.getKonacnaOcena(),
            studentiNaStudijskimProgramimaDTO,
            realizacijaPredmetaDTO
        );
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ArrayList<PohadjanjeDTO> findAll() {
        ArrayList<PohadjanjeDTO> list = new ArrayList<>();
        for (Pohadjanje e : pohadjanjeService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<PohadjanjeDTO> findById(@PathVariable("id") Long id) {
        Optional<Pohadjanje> opt = pohadjanjeService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<PohadjanjeDTO> deleteById(@PathVariable("id") Long id) {
        Optional<Pohadjanje> opt = pohadjanjeService.findById(id);
        if (opt.isPresent()) {
            PohadjanjeDTO dto = buildDTO(opt.get());
            pohadjanjeService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<PohadjanjeDTO> create(@RequestBody PohadjanjeDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<StudentNaStudijskomProgramu> studentiNaStudijskimProgramimaOpt = studentNaStudijskomProgramuService.findById(dto.getStudentiNaStudijskimProgramima().getId());
        if (!studentiNaStudijskimProgramimaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<RealizacijaPredmeta> realizacijaPredmetaOpt = realizacijaPredmetaService.findById(dto.getRealizacijaPredmeta().getId());
        if (!realizacijaPredmetaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Pohadjanje entity = new Pohadjanje(null, dto.getKonacnaOcena(), studentiNaStudijskimProgramimaOpt.get(), realizacijaPredmetaOpt.get());
        Pohadjanje saved = pohadjanjeService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PohadjanjeDTO> update(@PathVariable("id") Long id, @RequestBody PohadjanjeDTO dto) {
        Optional<Pohadjanje> opt = pohadjanjeService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Pohadjanje entity = opt.get();
        entity.setKonacnaOcena(dto.getKonacnaOcena());
        Optional<StudentNaStudijskomProgramu> studentiNaStudijskimProgramimaOpt = studentNaStudijskomProgramuService.findById(dto.getStudentiNaStudijskimProgramima().getId());
        if (!studentiNaStudijskimProgramimaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setStudentiNaStudijskimProgramima(studentiNaStudijskimProgramimaOpt.get());
        Optional<RealizacijaPredmeta> realizacijaPredmetaOpt = realizacijaPredmetaService.findById(dto.getRealizacijaPredmeta().getId());
        if (!realizacijaPredmetaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setRealizacijaPredmeta(realizacijaPredmetaOpt.get());
        Pohadjanje saved = pohadjanjeService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }
}