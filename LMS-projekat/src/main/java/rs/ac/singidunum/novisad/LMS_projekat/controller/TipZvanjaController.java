package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.TipZvanjaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.TipZvanja;
import rs.ac.singidunum.novisad.LMS_projekat.service.TipZvanjaService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.ZvanjeDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Zvanje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/tipoviZvanja")
public class TipZvanjaController {

    @Autowired
    private TipZvanjaService tipZvanjaService;

    private TipZvanjaDTO buildDTO(TipZvanja e) {
        List<ZvanjeDTO> zvanjaDTOList = new ArrayList<>();
        for (Zvanje item : e.getZvanja()) {
            zvanjaDTOList.add(new ZvanjeDTO(
                item.getId(),
                item.getDatumIzbora(),
                item.getDatumPrestanka()
            ));
        }
        return new TipZvanjaDTO(
            e.getId(),
            e.getNaziv(),
            zvanjaDTOList
        );
    }

    @RequestMapping(path = "", method = org.springframework.web.bind.annotation.RequestMethod.GET)
    public ArrayList<TipZvanjaDTO> findAll() {
        ArrayList<TipZvanjaDTO> list = new ArrayList<>();
        for (TipZvanja e : tipZvanjaService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<TipZvanjaDTO> findById(@PathVariable("id") Long id) {
        Optional<TipZvanja> opt = tipZvanjaService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<TipZvanjaDTO> deleteById(@PathVariable("id") Long id) {
        Optional<TipZvanja> opt = tipZvanjaService.findById(id);
        if (opt.isPresent()) {
            TipZvanjaDTO dto = buildDTO(opt.get());
            tipZvanjaService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<TipZvanjaDTO> create(@RequestBody TipZvanjaDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        TipZvanja entity = new TipZvanja(null, dto.getNaziv());
        TipZvanja saved = tipZvanjaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TipZvanjaDTO> update(@PathVariable("id") Long id, @RequestBody TipZvanjaDTO dto) {
        Optional<TipZvanja> opt = tipZvanjaService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        TipZvanja entity = opt.get();
        entity.setNaziv(dto.getNaziv());
        TipZvanja saved = tipZvanjaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}
