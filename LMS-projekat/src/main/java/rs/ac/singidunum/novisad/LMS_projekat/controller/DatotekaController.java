package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.DatotekaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Datoteka;
import rs.ac.singidunum.novisad.LMS_projekat.service.DatotekaService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.NastavniMaterijalDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.NastavniMaterijal;
import rs.ac.singidunum.novisad.LMS_projekat.dto.PravoPristupaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.PravoPristupa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/datoteke")
public class DatotekaController {

    @Autowired
    private DatotekaService datotekaService;

    //@Autowired
    //private NastavniMaterijalService nastavniMaterijalService;

    private DatotekaDTO buildDTO(Datoteka e) {
       
        return new DatotekaDTO(
          
        );
    }

    @RequestMapping(path = "", method =RequestMethod.GET)
    public ArrayList<DatotekaDTO> findAll() {
        ArrayList<DatotekaDTO> list = new ArrayList<>();
        for (Datoteka e : datotekaService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<DatotekaDTO> findById(@PathVariable("id") Long id) {
        Optional<Datoteka> opt = datotekaService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<DatotekaDTO> deleteById(@PathVariable("id") Long id) {
        Optional<Datoteka> opt = datotekaService.findById(id);
        if (opt.isPresent()) {
            DatotekaDTO dto = buildDTO(opt.get());
            datotekaService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<DatotekaDTO> create(@RequestBody DatotekaDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<NastavniMaterijal> nastavniMaterijalOpt = nastavniMaterijalService.findById(dto.getNastavniMaterijal().getId());
        if (!nastavniMaterijalOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Datoteka entity = new Datoteka(null, dto.getNaziv(), dto.getOpis(), dto.getUrl(), nastavniMaterijalOpt.get());
        Datoteka saved = datotekaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<DatotekaDTO> update(@PathVariable("id") Long id, @RequestBody DatotekaDTO dto) {
        Optional<Datoteka> opt = datotekaService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Datoteka entity = opt.get();
        entity.setNaziv(dto.getNaziv());
        entity.setOpis(dto.getOpis());
        entity.setUrl(dto.getUrl());
        Optional<NastavniMaterijal> nastavniMaterijalOpt = nastavniMaterijalService.findById(dto.getNastavniMaterijal().getId());
        if (!nastavniMaterijalOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setNastavniMaterijal(nastavniMaterijalOpt.get());
        Datoteka saved = datotekaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}
