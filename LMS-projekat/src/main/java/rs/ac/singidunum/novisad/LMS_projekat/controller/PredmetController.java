package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.PredmetDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Predmet;
import rs.ac.singidunum.novisad.LMS_projekat.service.PredmetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/predmeti")
public class PredmetController {

    @Autowired
    private PredmetService predmetService;

//    @Autowired
//    private GodinaStudijaService godinaStudijaService;

    private PredmetDTO buildDTO(Predmet e) {
        return new PredmetDTO();
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ArrayList<PredmetDTO> findAll() {
        ArrayList<PredmetDTO> list = new ArrayList<>();
        for (Predmet e : predmetService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<PredmetDTO> findById(@PathVariable("id") Long id) {
        Optional<Predmet> opt = predmetService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<PredmetDTO> deleteById(@PathVariable("id") Long id) {
        Optional<Predmet> opt = predmetService.findById(id);
        if (opt.isPresent()) {
            PredmetDTO dto = buildDTO(opt.get());
            predmetService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @PostMapping(path = "")
//    public ResponseEntity<PredmetDTO> create(@RequestBody PredmetDTO dto) {}

//    @PutMapping(path = "/{id}")
//    public ResponseEntity<PredmetDTO> update(@PathVariable("id") Long id, @RequestBody PredmetDTO dto) {}

}