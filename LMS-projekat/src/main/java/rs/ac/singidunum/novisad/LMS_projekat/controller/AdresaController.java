package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.AdresaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Adresa;
import rs.ac.singidunum.novisad.LMS_projekat.service.AdresaService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.MestoDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Mesto;
import rs.ac.singidunum.novisad.LMS_projekat.service.MestoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/adrese")
public class AdresaController {

    @Autowired
    private AdresaService adresaService;

    @Autowired
    private MestoService mestoService;

    private AdresaDTO buildDTO(Adresa e) {
        MestoDTO mestoDTO = new MestoDTO(
            e.getMesto().getId(),
            e.getMesto().getNaziv()
        );
        return new AdresaDTO(
            e.getId(),
            e.getUlica(),
            e.getBroj(),
            mestoDTO
        );
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ArrayList<AdresaDTO> findAll() {
        ArrayList<AdresaDTO> list = new ArrayList<>();
        for (Adresa e : adresaService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<AdresaDTO> findById(@PathVariable("id") Long id) {
        Optional<Adresa> opt = adresaService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<AdresaDTO> deleteById(@PathVariable("id") Long id) {
        Optional<Adresa> opt = adresaService.findById(id);
        if (opt.isPresent()) {
            AdresaDTO dto = buildDTO(opt.get());
            adresaService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<AdresaDTO> create(@RequestBody AdresaDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<Mesto> mestoOpt = mestoService.findById(dto.getMesto().getId());
        if (!mestoOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Adresa entity = new Adresa(null, dto.getUlica(), dto.getBroj(), mestoOpt.get());
        Adresa saved = adresaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AdresaDTO> update(@PathVariable("id") Long id, @RequestBody AdresaDTO dto) {
        Optional<Adresa> opt = adresaService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Adresa entity = opt.get();
        entity.setUlica(dto.getUlica());
        entity.setBroj(dto.getBroj());
        Optional<Mesto> mestoOpt = mestoService.findById(dto.getMesto().getId());
        if (!mestoOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setMesto(mestoOpt.get());
        Adresa saved = adresaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}
