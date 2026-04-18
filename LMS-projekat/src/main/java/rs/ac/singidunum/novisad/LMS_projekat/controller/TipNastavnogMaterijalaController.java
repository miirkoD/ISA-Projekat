package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.NastavniMaterijalDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.TipNastavnogMaterijalaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.NastavniMaterijal;
import rs.ac.singidunum.novisad.LMS_projekat.model.TipNastavnogMaterijala;
import rs.ac.singidunum.novisad.LMS_projekat.service.TipNastavnogMaterijalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/tipoviNastavnogMaterijala")
public class TipNastavnogMaterijalaController {

    @Autowired
    private TipNastavnogMaterijalaService tipNastavnogMaterijalaService;

    private TipNastavnogMaterijalaDTO buildDTO(TipNastavnogMaterijala e) {
        List<NastavniMaterijalDTO> nastavniMaterijaliDTOList = new ArrayList<>();
        for (NastavniMaterijal item : e.getNastavniMaterijali()) {
            nastavniMaterijaliDTOList.add(new NastavniMaterijalDTO(
                item.getId(),
                item.getNaziv(),
                item.getOpis()
            ));
        }
        return new TipNastavnogMaterijalaDTO(
            e.getId(),
            e.getNaziv(),
            nastavniMaterijaliDTOList
        );
    }

    @RequestMapping(path = "", method =RequestMethod.GET)
    public ArrayList<TipNastavnogMaterijalaDTO> findAll() {
        ArrayList<TipNastavnogMaterijalaDTO> list = new ArrayList<>();
        for (TipNastavnogMaterijala e : tipNastavnogMaterijalaService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<TipNastavnogMaterijalaDTO> findById(@PathVariable("id") Long id) {
        Optional<TipNastavnogMaterijala> opt = tipNastavnogMaterijalaService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<TipNastavnogMaterijalaDTO> deleteById(@PathVariable("id") Long id) {
        Optional<TipNastavnogMaterijala> opt = tipNastavnogMaterijalaService.findById(id);
        if (opt.isPresent()) {
            TipNastavnogMaterijalaDTO dto = buildDTO(opt.get());
            tipNastavnogMaterijalaService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<TipNastavnogMaterijalaDTO> create(@RequestBody TipNastavnogMaterijalaDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        TipNastavnogMaterijala entity = new TipNastavnogMaterijala(null, dto.getNaziv());
        TipNastavnogMaterijala saved = tipNastavnogMaterijalaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TipNastavnogMaterijalaDTO> update(@PathVariable("id") Long id, @RequestBody TipNastavnogMaterijalaDTO dto) {
        Optional<TipNastavnogMaterijala> opt = tipNastavnogMaterijalaService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        TipNastavnogMaterijala entity = opt.get();
        entity.setNaziv(dto.getNaziv());
        TipNastavnogMaterijala saved = tipNastavnogMaterijalaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}