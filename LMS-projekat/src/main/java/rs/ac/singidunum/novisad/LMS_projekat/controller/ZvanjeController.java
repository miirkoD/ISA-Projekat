package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.ZvanjeDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Zvanje;
import rs.ac.singidunum.novisad.LMS_projekat.service.ZvanjeService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.NastavnikDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Nastavnik;
import rs.ac.singidunum.novisad.LMS_projekat.service.NastavnikService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.TipZvanjaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.TipZvanja;
import rs.ac.singidunum.novisad.LMS_projekat.service.TipZvanjaService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.NaucnaOblastDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.NaucnaOblast;
import rs.ac.singidunum.novisad.LMS_projekat.service.NaucnaOblastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/zvanja")
public class ZvanjeController {

    @Autowired
    private ZvanjeService zvanjeService;

    @Autowired
    private NastavnikService nastavnikService;

    @Autowired
    private TipZvanjaService tipZvanjaService;

    @Autowired
    private NaucnaOblastService naucnaOblastService;

    private ZvanjeDTO buildDTO(Zvanje e) {
        NastavnikDTO nastavnikDTO = new NastavnikDTO(
            e.getNastavnik().getId(),
            e.getNastavnik().getBiografija()
        );
        TipZvanjaDTO tipZvanjaDTO = new TipZvanjaDTO(
            e.getTipZvanja().getId(),
            e.getTipZvanja().getNaziv()
        );
        NaucnaOblastDTO naucnaOblastDTO = new NaucnaOblastDTO(
            e.getNaucnaOblast().getId(),
            e.getNaucnaOblast().getNaziv()
        );
        return new ZvanjeDTO(
            e.getId(),
            e.getDatumIzbora(),
            e.getDatumPrestanka(),
            nastavnikDTO,
            tipZvanjaDTO,
            naucnaOblastDTO
        );
    }

    @RequestMapping(path = "", method = org.springframework.web.bind.annotation.RequestMethod.GET)
    public ArrayList<ZvanjeDTO> findAll() {
        ArrayList<ZvanjeDTO> list = new ArrayList<>();
        for (Zvanje e : zvanjeService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<ZvanjeDTO> findById(@PathVariable("id") Long id) {
        Optional<Zvanje> opt = zvanjeService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ZvanjeDTO> deleteById(@PathVariable("id") Long id) {
        Optional<Zvanje> opt = zvanjeService.findById(id);
        if (opt.isPresent()) {
            ZvanjeDTO dto = buildDTO(opt.get());
            zvanjeService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<ZvanjeDTO> create(@RequestBody ZvanjeDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<Nastavnik> nastavnikOpt = nastavnikService.findById(dto.getNastavnik().getId());
        if (!nastavnikOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<TipZvanja> tipZvanjaOpt = tipZvanjaService.findById(dto.getTipZvanja().getId());
        if (!tipZvanjaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<NaucnaOblast> naucnaOblastOpt = naucnaOblastService.findById(dto.getNaucnaOblast().getId());
        if (!naucnaOblastOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Zvanje entity = new Zvanje(null, dto.getDatumIzbora(), dto.getDatumPrestanka(), nastavnikOpt.get(), tipZvanjaOpt.get(), naucnaOblastOpt.get());
        Zvanje saved = zvanjeService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ZvanjeDTO> update(@PathVariable("id") Long id, @RequestBody ZvanjeDTO dto) {
        Optional<Zvanje> opt = zvanjeService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Zvanje entity = opt.get();
        entity.setDatumIzbora(dto.getDatumIzbora());
        entity.setDatumPrestanka(dto.getDatumPrestanka());
        Optional<Nastavnik> nastavnikOpt = nastavnikService.findById(dto.getNastavnik().getId());
        if (!nastavnikOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setNastavnik(nastavnikOpt.get());
        Optional<TipZvanja> tipZvanjaOpt = tipZvanjaService.findById(dto.getTipZvanja().getId());
        if (!tipZvanjaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setTipZvanja(tipZvanjaOpt.get());
        Optional<NaucnaOblast> naucnaOblastOpt = naucnaOblastService.findById(dto.getNaucnaOblast().getId());
        if (!naucnaOblastOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setNaucnaOblast(naucnaOblastOpt.get());
        Zvanje saved = zvanjeService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}
