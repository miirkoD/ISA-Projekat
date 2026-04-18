package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.TipNastaveDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.TipNastave;
import rs.ac.singidunum.novisad.LMS_projekat.service.TipNastaveService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.TerminNastaveDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.TerminNastave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/tipoviNastave")
public class TipNastaveController {

    @Autowired
    private TipNastaveService tipNastaveService;

    private TipNastaveDTO buildDTO(TipNastave e) {
        List<TerminNastaveDTO> terminiNastaveDTOList = new ArrayList<>();
        for (TerminNastave item : e.getTerminiNastave()) {
            terminiNastaveDTOList.add(new TerminNastaveDTO(
                item.getId(),
                item.getPocetak(),
                item.getKraj()
            ));
        }
        return new TipNastaveDTO(
            e.getId(),
            e.getNaziv(),
            terminiNastaveDTOList
        );
    }

    @RequestMapping(path = "", method =RequestMethod.GET)
    public ArrayList<TipNastaveDTO> findAll() {
        ArrayList<TipNastaveDTO> list = new ArrayList<>();
        for (TipNastave e : tipNastaveService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<TipNastaveDTO> findById(@PathVariable("id") Long id) {
        Optional<TipNastave> opt = tipNastaveService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<TipNastaveDTO> deleteById(@PathVariable("id") Long id) {
        Optional<TipNastave> opt = tipNastaveService.findById(id);
        if (opt.isPresent()) {
            TipNastaveDTO dto = buildDTO(opt.get());
            tipNastaveService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<TipNastaveDTO> create(@RequestBody TipNastaveDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        TipNastave entity = new TipNastave(null, dto.getNaziv());
        TipNastave saved = tipNastaveService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TipNastaveDTO> update(@PathVariable("id") Long id, @RequestBody TipNastaveDTO dto) {
        Optional<TipNastave> opt = tipNastaveService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        TipNastave entity = opt.get();
        entity.setNaziv(dto.getNaziv());
        TipNastave saved = tipNastaveService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}