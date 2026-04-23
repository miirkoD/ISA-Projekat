package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.AdministrativnoAngazovanjeDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.AdministrativnoAngazovanje;
import rs.ac.singidunum.novisad.LMS_projekat.service.AdministrativnoAngazovanjeService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.NastavnikDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Nastavnik;
import rs.ac.singidunum.novisad.LMS_projekat.service.NastavnikService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.StudijskiProgramDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.StudijskiProgram;
import rs.ac.singidunum.novisad.LMS_projekat.service.StudijskiProgramService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.FakultetDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Fakultet;
import rs.ac.singidunum.novisad.LMS_projekat.service.FakultetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/administrativnaAngazovanja")
public class AdministrativnoAngazovanjeController {

    @Autowired
    private AdministrativnoAngazovanjeService administrativnoAngazovanjeService;

    @Autowired
    private NastavnikService nastavnikService;

    @Autowired
    private StudijskiProgramService studijskiProgramService;

    @Autowired
    private FakultetService fakultetService;

    private AdministrativnoAngazovanjeDTO buildDTO(AdministrativnoAngazovanje e) {
        NastavnikDTO nastavnikDTO = new NastavnikDTO(
            e.getNastavnik().getId(),
            e.getNastavnik().getBiografija()
        );
        StudijskiProgramDTO studijskiProgramDTO = new StudijskiProgramDTO(
            e.getStudijskiProgram().getId(),
            e.getStudijskiProgram().getNaziv()
        );
        FakultetDTO fakultetDTO = new FakultetDTO(
            e.getFakultet().getId(),
            e.getFakultet().getNaziv()
        );
        return new AdministrativnoAngazovanjeDTO(
            e.getId(),
            e.getPocetak(),
            e.getKraj(),
            nastavnikDTO,
            studijskiProgramDTO,
            fakultetDTO
        );
    }

    @RequestMapping(path = "", method = org.springframework.web.bind.annotation.RequestMethod.GET)
    public ArrayList<AdministrativnoAngazovanjeDTO> findAll() {
        ArrayList<AdministrativnoAngazovanjeDTO> list = new ArrayList<>();
        for (AdministrativnoAngazovanje e : administrativnoAngazovanjeService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<AdministrativnoAngazovanjeDTO> findById(@PathVariable("id") Long id) {
        Optional<AdministrativnoAngazovanje> opt = administrativnoAngazovanjeService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<AdministrativnoAngazovanjeDTO> deleteById(@PathVariable("id") Long id) {
        Optional<AdministrativnoAngazovanje> opt = administrativnoAngazovanjeService.findById(id);
        if (opt.isPresent()) {
            AdministrativnoAngazovanjeDTO dto = buildDTO(opt.get());
            administrativnoAngazovanjeService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<AdministrativnoAngazovanjeDTO> create(@RequestBody AdministrativnoAngazovanjeDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<Nastavnik> nastavnikOpt = nastavnikService.findById(dto.getNastavnik().getId());
        if (!nastavnikOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<StudijskiProgram> studijskiProgramOpt = studijskiProgramService.findById(dto.getStudijskiProgram().getId());
        if (!studijskiProgramOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<Fakultet> fakultetOpt = fakultetService.findById(dto.getFakultet().getId());
        if (!fakultetOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        AdministrativnoAngazovanje entity = new AdministrativnoAngazovanje(null, dto.getPocetak(), dto.getKraj(), nastavnikOpt.get(), studijskiProgramOpt.get(), fakultetOpt.get());
        AdministrativnoAngazovanje saved = administrativnoAngazovanjeService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AdministrativnoAngazovanjeDTO> update(@PathVariable("id") Long id, @RequestBody AdministrativnoAngazovanjeDTO dto) {
        Optional<AdministrativnoAngazovanje> opt = administrativnoAngazovanjeService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        AdministrativnoAngazovanje entity = opt.get();
        entity.setPocetak(dto.getPocetak());
        entity.setKraj(dto.getKraj());
        Optional<Nastavnik> nastavnikOpt = nastavnikService.findById(dto.getNastavnik().getId());
        if (!nastavnikOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setNastavnik(nastavnikOpt.get());
        Optional<StudijskiProgram> studijskiProgramOpt = studijskiProgramService.findById(dto.getStudijskiProgram().getId());
        if (!studijskiProgramOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setStudijskiProgram(studijskiProgramOpt.get());
        Optional<Fakultet> fakultetOpt = fakultetService.findById(dto.getFakultet().getId());
        if (!fakultetOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setFakultet(fakultetOpt.get());
        AdministrativnoAngazovanje saved = administrativnoAngazovanjeService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}
