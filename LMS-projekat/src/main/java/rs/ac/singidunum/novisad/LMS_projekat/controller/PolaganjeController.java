package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.PolaganjeDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Polaganje;
import rs.ac.singidunum.novisad.LMS_projekat.service.PolaganjeService;
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

//    @Autowired
//    private StudentNaStudijskomProgramuService studentNaStudijskomProgramuService;

    @Autowired
    private EvaluacijaZnanjaService evaluacijaZnanjaService;

    private PolaganjeDTO buildDTO(Polaganje e) {
        return new PolaganjeDTO();
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

//    @PostMapping(path = "")
//    public ResponseEntity<PolaganjeDTO> create(@RequestBody PolaganjeDTO dto) {}

//    @PutMapping(path = "/{id}")
//    public ResponseEntity<PolaganjeDTO> update(@PathVariable("id") Long id, @RequestBody PolaganjeDTO dto) {}

}