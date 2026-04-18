package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.DrzavaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Drzava;
import rs.ac.singidunum.novisad.LMS_projekat.service.DrzavaService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.MestoDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Mesto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/drzave")
public class DrzavaController {

    @Autowired
    private DrzavaService drzavaService;

    private DrzavaDTO buildDTO(Drzava e) {
        List<MestoDTO> mestaDTOList = new ArrayList<>();
        for (Mesto item : e.getMesta()) {
            mestaDTOList.add(new MestoDTO(
                item.getId(),
                item.getNaziv()
            ));
        }
        return new DrzavaDTO(
            e.getId(),
            e.getNaziv(),
            mestaDTOList
        );
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ArrayList<DrzavaDTO> findAll() {
        ArrayList<DrzavaDTO> list = new ArrayList<>();
        for (Drzava e : drzavaService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<DrzavaDTO> findById(@PathVariable("id") Long id) {
        Optional<Drzava> opt = drzavaService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<DrzavaDTO> deleteById(@PathVariable("id") Long id) {
        Optional<Drzava> opt = drzavaService.findById(id);
        if (opt.isPresent()) {
            DrzavaDTO dto = buildDTO(opt.get());
            drzavaService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<DrzavaDTO> create(@RequestBody DrzavaDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Drzava entity = new Drzava(null, dto.getNaziv());
        Drzava saved = drzavaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<DrzavaDTO> update(@PathVariable("id") Long id, @RequestBody DrzavaDTO dto) {
        Optional<Drzava> opt = drzavaService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Drzava entity = opt.get();
        entity.setNaziv(dto.getNaziv());
        Drzava saved = drzavaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}
