package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.PohadjanjeDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Pohadjanje;
import rs.ac.singidunum.novisad.LMS_projekat.service.PohadjanjeService;
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

//    @Autowired
//    private StudentNaStudijskomProgramuService studentNaStudijskomProgramuService;

    private PohadjanjeDTO buildDTO(Pohadjanje e) {
        return new PohadjanjeDTO();
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

//    @PostMapping(path = "")
//    public ResponseEntity<PohadjanjeDTO> create(@RequestBody PohadjanjeDTO dto) {    }

//    @PutMapping(path = "/{id}")
//    public ResponseEntity<PohadjanjeDTO> update(@PathVariable("id") Long id, @RequestBody PohadjanjeDTO dto) {}

}