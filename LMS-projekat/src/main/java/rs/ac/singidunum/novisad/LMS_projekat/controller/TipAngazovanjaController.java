package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.TipAngazovanjaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.TipAngazovanja;
import rs.ac.singidunum.novisad.LMS_projekat.service.TipAngazovanjaService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.AngazovanjeDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Angazovanje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/tipoviAngazovanja")
public class TipAngazovanjaController {

    @Autowired
    private TipAngazovanjaService tipAngazovanjaService;

    private TipAngazovanjaDTO buildDTO(TipAngazovanja e) {
        List<AngazovanjeDTO> angazovanjaDTOList = new ArrayList<>();
        for (Angazovanje item : e.getAngazovanja()) {
            angazovanjaDTOList.add(new AngazovanjeDTO(
                item.getId(),
                item.getPocetak(),
                item.getKraj()
            ));
        }
        return new TipAngazovanjaDTO(
            e.getId(),
            e.getNaziv(),
            angazovanjaDTOList
        );
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ArrayList<TipAngazovanjaDTO> findAll() {
        ArrayList<TipAngazovanjaDTO> list = new ArrayList<>();
        for (TipAngazovanja e : tipAngazovanjaService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<TipAngazovanjaDTO> findById(@PathVariable("id") Long id) {
        Optional<TipAngazovanja> opt = tipAngazovanjaService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<TipAngazovanjaDTO> deleteById(@PathVariable("id") Long id) {
        Optional<TipAngazovanja> opt = tipAngazovanjaService.findById(id);
        if (opt.isPresent()) {
            TipAngazovanjaDTO dto = buildDTO(opt.get());
            tipAngazovanjaService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<TipAngazovanjaDTO> create(@RequestBody TipAngazovanjaDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        TipAngazovanja entity = new TipAngazovanja(null, dto.getNaziv());
        TipAngazovanja saved = tipAngazovanjaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TipAngazovanjaDTO> update(@PathVariable("id") Long id, @RequestBody TipAngazovanjaDTO dto) {
        Optional<TipAngazovanja> opt = tipAngazovanjaService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        TipAngazovanja entity = opt.get();
        entity.setNaziv(dto.getNaziv());
        TipAngazovanja saved = tipAngazovanjaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}