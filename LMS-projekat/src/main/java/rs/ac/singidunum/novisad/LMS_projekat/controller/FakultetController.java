package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.FakultetDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Fakultet;
import rs.ac.singidunum.novisad.LMS_projekat.service.FakultetService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.UniverzitetDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Univerzitet;
import rs.ac.singidunum.novisad.LMS_projekat.service.UniverzitetService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.StudijskiProgramDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.StudijskiProgram;
import rs.ac.singidunum.novisad.LMS_projekat.dto.AdministrativnoAngazovanjeDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.AdministrativnoAngazovanje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/fakulteti")
public class FakultetController {

    @Autowired
    private FakultetService fakultetService;

    @Autowired
    private UniverzitetService univerzitetService;

    private FakultetDTO buildDTO(Fakultet e) {
        UniverzitetDTO univerzitetDTO = new UniverzitetDTO(
            e.getUniverzitet().getId(),
            e.getUniverzitet().getNaziv(),
            e.getUniverzitet().getDatumOsnivanja()
        );
        List<StudijskiProgramDTO> studijskiProgramiDTOList = new ArrayList<>();
        for (StudijskiProgram item : e.getStudijskiProgrami()) {
            studijskiProgramiDTOList.add(new StudijskiProgramDTO(
                item.getId(),
                item.getNaziv()
            ));
        }
        List<AdministrativnoAngazovanjeDTO> administrativnoAngazovanjeDTOList = new ArrayList<>();
        for (AdministrativnoAngazovanje item : e.getAdministrativnoAngazovanje()) {
            administrativnoAngazovanjeDTOList.add(new AdministrativnoAngazovanjeDTO(
                item.getId(),
                item.getPocetak(),
                item.getKraj()
            ));
        }
        return new FakultetDTO(
            e.getId(),
            e.getNaziv(),
            univerzitetDTO,
            studijskiProgramiDTOList,
            administrativnoAngazovanjeDTOList
        );
    }

    @RequestMapping(path = "", method = org.springframework.web.bind.annotation.RequestMethod.GET)
    public ArrayList<FakultetDTO> findAll() {
        ArrayList<FakultetDTO> list = new ArrayList<>();
        for (Fakultet e : fakultetService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<FakultetDTO> findById(@PathVariable("id") Long id) {
        Optional<Fakultet> opt = fakultetService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<FakultetDTO> deleteById(@PathVariable("id") Long id) {
        Optional<Fakultet> opt = fakultetService.findById(id);
        if (opt.isPresent()) {
            FakultetDTO dto = buildDTO(opt.get());
            fakultetService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<FakultetDTO> create(@RequestBody FakultetDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<Univerzitet> univerzitetOpt = univerzitetService.findById(dto.getUniverzitet().getId());
        if (!univerzitetOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Fakultet entity = new Fakultet(null, dto.getNaziv(), univerzitetOpt.get());
        Fakultet saved = fakultetService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<FakultetDTO> update(@PathVariable("id") Long id, @RequestBody FakultetDTO dto) {
        Optional<Fakultet> opt = fakultetService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Fakultet entity = opt.get();
        entity.setNaziv(dto.getNaziv());
        Optional<Univerzitet> univerzitetOpt = univerzitetService.findById(dto.getUniverzitet().getId());
        if (!univerzitetOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setUniverzitet(univerzitetOpt.get());
        Fakultet saved = fakultetService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}
