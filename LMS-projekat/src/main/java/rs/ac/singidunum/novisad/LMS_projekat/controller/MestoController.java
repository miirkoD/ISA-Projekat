package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.MestoDTO;

import rs.ac.singidunum.novisad.LMS_projekat.model.Mesto;
import rs.ac.singidunum.novisad.LMS_projekat.service.MestoService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.DrzavaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Drzava;
import rs.ac.singidunum.novisad.LMS_projekat.service.DrzavaService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.AdresaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Adresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/mesta")
public class MestoController {

    @Autowired
    private MestoService mestoService;

    @Autowired
    private DrzavaService drzavaService;

    private MestoDTO buildDTO(Mesto e) {
        DrzavaDTO drzavaDTO = new DrzavaDTO(
            e.getDrzava().getId(),
            e.getDrzava().getNaziv()
        );
        List<AdresaDTO> adreseDTOList = new ArrayList<>();
        for (Adresa item : e.getAdrese()) {
            adreseDTOList.add(new AdresaDTO(
                item.getId(),
                item.getUlica(),
                item.getBroj()
            ));
        }
        return new MestoDTO(
            e.getId(),
            e.getNaziv(),
            drzavaDTO,
            adreseDTOList
        );
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ArrayList<MestoDTO> findAll() {
        ArrayList<MestoDTO> list = new ArrayList<>();
        for (Mesto e : mestoService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<MestoDTO> findById(@PathVariable("id") Long id) {
        Optional<Mesto> opt = mestoService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<MestoDTO> deleteById(@PathVariable("id") Long id) {
        Optional<Mesto> opt = mestoService.findById(id);
        if (opt.isPresent()) {
            MestoDTO dto = buildDTO(opt.get());
            mestoService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<MestoDTO> create(@RequestBody MestoDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<Drzava> drzavaOpt = drzavaService.findById(dto.getDrzava().getId());
        if (!drzavaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Mesto entity = new Mesto(null, dto.getNaziv(), drzavaOpt.get());
        Mesto saved = mestoService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<MestoDTO> update(@PathVariable("id") Long id, @RequestBody MestoDTO dto) {
        Optional<Mesto> opt = mestoService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Mesto entity = opt.get();
        entity.setNaziv(dto.getNaziv());
        Optional<Drzava> drzavaOpt = drzavaService.findById(dto.getDrzava().getId());
        if (!drzavaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setDrzava(drzavaOpt.get());
        Mesto saved = mestoService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}
