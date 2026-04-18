package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.RealizacijaPredmetaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.RealizacijaPredmeta;
import rs.ac.singidunum.novisad.LMS_projekat.service.RealizacijaPredmetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/realizacijePredmeta")
public class RealizacijaPredmetaController {

    @Autowired
    private RealizacijaPredmetaService realizacijaPredmetaService;

//    @Autowired
//    private SkolskaGodinaService skolskaGodinaService;

    private RealizacijaPredmetaDTO buildDTO(RealizacijaPredmeta e) {
        return new RealizacijaPredmetaDTO();
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ArrayList<RealizacijaPredmetaDTO> findAll() {
        ArrayList<RealizacijaPredmetaDTO> list = new ArrayList<>();
        for (RealizacijaPredmeta e : realizacijaPredmetaService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<RealizacijaPredmetaDTO> findById(@PathVariable("id") Long id) {
        Optional<RealizacijaPredmeta> opt = realizacijaPredmetaService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<RealizacijaPredmetaDTO> deleteById(@PathVariable("id") Long id) {
        Optional<RealizacijaPredmeta> opt = realizacijaPredmetaService.findById(id);
        if (opt.isPresent()) {
            RealizacijaPredmetaDTO dto = buildDTO(opt.get());
            realizacijaPredmetaService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @PostMapping(path = "")
//    public ResponseEntity<RealizacijaPredmetaDTO> create(@RequestBody RealizacijaPredmetaDTO dto) {}

//    @PutMapping(path = "/{id}")
//    public ResponseEntity<RealizacijaPredmetaDTO> update(@PathVariable("id") Long id, @RequestBody RealizacijaPredmetaDTO dto) {}

}