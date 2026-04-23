package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.StudijskiProgramDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.StudijskiProgram;
import rs.ac.singidunum.novisad.LMS_projekat.service.StudijskiProgramService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.FakultetDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Fakultet;
import rs.ac.singidunum.novisad.LMS_projekat.service.FakultetService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.GodinaStudijaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.GodinaStudija;
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
@RequestMapping(path = "/api/studijskiProgrami")
public class StudijskiProgramController {

    @Autowired
    private StudijskiProgramService studijskiProgramService;

    @Autowired
    private FakultetService fakultetService;

    private StudijskiProgramDTO buildDTO(StudijskiProgram e) {
        FakultetDTO fakultetDTO = new FakultetDTO(
            e.getFakultet().getId(),
            e.getFakultet().getNaziv()
        );
        List<GodinaStudijaDTO> godineStudijaDTOList = new ArrayList<>();
        for (GodinaStudija item : e.getGodineStudija()) {
            godineStudijaDTOList.add(new GodinaStudijaDTO(
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
        return new StudijskiProgramDTO(
            e.getId(),
            e.getNaziv(),
            fakultetDTO,
            godineStudijaDTOList,
            administrativnoAngazovanjeDTOList
        );
    }

    @RequestMapping(path = "", method = org.springframework.web.bind.annotation.RequestMethod.GET)
    public ArrayList<StudijskiProgramDTO> findAll() {
        ArrayList<StudijskiProgramDTO> list = new ArrayList<>();
        for (StudijskiProgram e : studijskiProgramService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<StudijskiProgramDTO> findById(@PathVariable("id") Long id) {
        Optional<StudijskiProgram> opt = studijskiProgramService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<StudijskiProgramDTO> deleteById(@PathVariable("id") Long id) {
        Optional<StudijskiProgram> opt = studijskiProgramService.findById(id);
        if (opt.isPresent()) {
            StudijskiProgramDTO dto = buildDTO(opt.get());
            studijskiProgramService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<StudijskiProgramDTO> create(@RequestBody StudijskiProgramDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<Fakultet> fakultetOpt = fakultetService.findById(dto.getFakultet().getId());
        if (!fakultetOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        StudijskiProgram entity = new StudijskiProgram(null, dto.getNaziv(), fakultetOpt.get());
        StudijskiProgram saved = studijskiProgramService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<StudijskiProgramDTO> update(@PathVariable("id") Long id, @RequestBody StudijskiProgramDTO dto) {
        Optional<StudijskiProgram> opt = studijskiProgramService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        StudijskiProgram entity = opt.get();
        entity.setNaziv(dto.getNaziv());
        Optional<Fakultet> fakultetOpt = fakultetService.findById(dto.getFakultet().getId());
        if (!fakultetOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setFakultet(fakultetOpt.get());
        StudijskiProgram saved = studijskiProgramService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}
