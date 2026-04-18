package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.NastavnikDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Nastavnik;
import rs.ac.singidunum.novisad.LMS_projekat.service.NastavnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/nastavnici")
public class NastavnikController {

    @Autowired
    private NastavnikService nastavnikService;

    private NastavnikDTO buildDTO(Nastavnik e) {
     
        return new NastavnikDTO(
         
        );
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ArrayList<NastavnikDTO> findAll() {
        ArrayList<NastavnikDTO> list = new ArrayList<>();
        for (Nastavnik e : nastavnikService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<NastavnikDTO> findById(@PathVariable("id") Long id) {
        Optional<Nastavnik> opt = nastavnikService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<NastavnikDTO> deleteById(@PathVariable("id") Long id) {
        Optional<Nastavnik> opt = nastavnikService.findById(id);
        if (opt.isPresent()) {
            NastavnikDTO dto = buildDTO(opt.get());
            nastavnikService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<NastavnikDTO> create(@RequestBody NastavnikDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Nastavnik entity = new Nastavnik(null, dto.getBiografija());
        Nastavnik saved = nastavnikService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<NastavnikDTO> update(@PathVariable("id") Long id, @RequestBody NastavnikDTO dto) {
        Optional<Nastavnik> opt = nastavnikService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Nastavnik entity = opt.get();
        entity.setBiografija(dto.getBiografija());
        Nastavnik saved = nastavnikService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}
