package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.EvaluacijaZnanjaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.PolaganjeDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.StudentNaStudijskomProgramuDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.EvaluacijaZnanja;
import rs.ac.singidunum.novisad.LMS_projekat.model.Polaganje;
import rs.ac.singidunum.novisad.LMS_projekat.model.StudentNaStudijskomProgramu;
import rs.ac.singidunum.novisad.LMS_projekat.service.PolaganjeService;
import rs.ac.singidunum.novisad.LMS_projekat.service.StudentNaStudijskomProgramuService;
import rs.ac.singidunum.novisad.LMS_projekat.service.EvaluacijaZnanjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/polaganja")
public class PolaganjeController {

    @Autowired
    private PolaganjeService polaganjeService;

    @Autowired
    private StudentNaStudijskomProgramuService studentNaStudijskomProgramuService;

    @Autowired
    private EvaluacijaZnanjaService evaluacijaZnanjaService;

    private PolaganjeDTO buildDTO(Polaganje e) {
        StudentNaStudijskomProgramuDTO studentiNaStudijskimProgramimaDTO = new StudentNaStudijskomProgramuDTO(
            e.getStudentiNaStudijskimProgramima().getId(),
            e.getStudentiNaStudijskimProgramima().getBrojIndeksa()
        );
        EvaluacijaZnanjaDTO evaluacijaZnanjaDTO = new EvaluacijaZnanjaDTO(
            e.getEvaluacijaZnanja().getId(),
            e.getEvaluacijaZnanja().getPocetak(),
            e.getEvaluacijaZnanja().getKraj(),
            e.getEvaluacijaZnanja().getBodovi()
        );
        return new PolaganjeDTO(
            e.getId(),
            e.getBodovi(),
            e.getNapomena(),
            studentiNaStudijskimProgramimaDTO,
            evaluacijaZnanjaDTO
        );
    }

    @RequestMapping(path = "", method =RequestMethod.GET)
    public ArrayList<PolaganjeDTO> findAll() {
        ArrayList<PolaganjeDTO> list = new ArrayList<>();
        for (Polaganje e : polaganjeService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<PolaganjeDTO> findById(@PathVariable("id") Long id) {
        Optional<Polaganje> opt = polaganjeService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<PolaganjeDTO> deleteById(@PathVariable("id") Long id) {
        Optional<Polaganje> opt = polaganjeService.findById(id);
        if (opt.isPresent()) {
            PolaganjeDTO dto = buildDTO(opt.get());
            polaganjeService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<PolaganjeDTO> create(@RequestBody PolaganjeDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<StudentNaStudijskomProgramu> studentiNaStudijskimProgramimaOpt = studentNaStudijskomProgramuService.findById(dto.getStudentiNaStudijskimProgramima().getId());
        if (!studentiNaStudijskimProgramimaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<EvaluacijaZnanja> evaluacijaZnanjaOpt = evaluacijaZnanjaService.findById(dto.getEvaluacijaZnanja().getId());
        if (!evaluacijaZnanjaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Polaganje entity = new Polaganje(null, dto.getBodovi(), dto.getNapomena(), studentiNaStudijskimProgramimaOpt.get(), evaluacijaZnanjaOpt.get());
        Polaganje saved = polaganjeService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PolaganjeDTO> update(@PathVariable("id") Long id, @RequestBody PolaganjeDTO dto) {
        Optional<Polaganje> opt = polaganjeService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Polaganje entity = opt.get();
        entity.setBodovi(dto.getBodovi());
        entity.setNapomena(dto.getNapomena());
        Optional<StudentNaStudijskomProgramu> studentiNaStudijskimProgramimaOpt = studentNaStudijskomProgramuService.findById(dto.getStudentiNaStudijskimProgramima().getId());
        if (!studentiNaStudijskimProgramimaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setStudentiNaStudijskimProgramima(studentiNaStudijskimProgramimaOpt.get());
        Optional<EvaluacijaZnanja> evaluacijaZnanjaOpt = evaluacijaZnanjaService.findById(dto.getEvaluacijaZnanja().getId());
        if (!evaluacijaZnanjaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setEvaluacijaZnanja(evaluacijaZnanjaOpt.get());
        Polaganje saved = polaganjeService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}