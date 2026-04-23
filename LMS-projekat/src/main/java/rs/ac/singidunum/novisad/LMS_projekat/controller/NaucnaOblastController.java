package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.NaucnaOblastDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.NaucnaOblast;
import rs.ac.singidunum.novisad.LMS_projekat.service.NaucnaOblastService;
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
@RequestMapping(path = "/api/naucneOblasti")
public class NaucnaOblastController {

    @Autowired
    private NaucnaOblastService naucnaOblastService;

    private NaucnaOblastDTO buildDTO(NaucnaOblast e) {
        List<ZvanjeDTO> zvanjaDTOList = new ArrayList<>();
        for (Zvanje item : e.getZvanja()) {
            zvanjaDTOList.add(new ZvanjeDTO(
                item.getId(),
                item.getDatumIzbora(),
                item.getDatumPrestanka()
            ));
        }
        return new NaucnaOblastDTO(
            e.getId(),
            e.getNaziv(),
            zvanjaDTOList
        );
    }

    @RequestMapping(path = "", method = org.springframework.web.bind.annotation.RequestMethod.GET)
    public ArrayList<NaucnaOblastDTO> findAll() {
        ArrayList<NaucnaOblastDTO> list = new ArrayList<>();
        for (NaucnaOblast e : naucnaOblastService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<NaucnaOblastDTO> findById(@PathVariable("id") Long id) {
        Optional<NaucnaOblast> opt = naucnaOblastService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<NaucnaOblastDTO> deleteById(@PathVariable("id") Long id) {
        Optional<NaucnaOblast> opt = naucnaOblastService.findById(id);
        if (opt.isPresent()) {
            NaucnaOblastDTO dto = buildDTO(opt.get());
            naucnaOblastService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<NaucnaOblastDTO> create(@RequestBody NaucnaOblastDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        NaucnaOblast entity = new NaucnaOblast(null, dto.getNaziv());
        NaucnaOblast saved = naucnaOblastService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<NaucnaOblastDTO> update(@PathVariable("id") Long id, @RequestBody NaucnaOblastDTO dto) {
        Optional<NaucnaOblast> opt = naucnaOblastService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        NaucnaOblast entity = opt.get();
        entity.setNaziv(dto.getNaziv());
        NaucnaOblast saved = naucnaOblastService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}
