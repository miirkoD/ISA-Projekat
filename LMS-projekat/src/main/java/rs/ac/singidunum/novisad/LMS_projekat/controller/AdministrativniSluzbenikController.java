package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.AdministrativniSluzbenikDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.AdministrativniSluzbenik;
import rs.ac.singidunum.novisad.LMS_projekat.service.AdministrativniSluzbenikService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.DodelaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Dodela;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/administrativniSluzbenici")
public class AdministrativniSluzbenikController {

    @Autowired
    private AdministrativniSluzbenikService administrativniSluzbenikService;

    private AdministrativniSluzbenikDTO buildDTO(AdministrativniSluzbenik e) {
        List<DodelaDTO> dodeleDTOList = new ArrayList<>();
        for (Dodela item : e.getDodele()) {
            dodeleDTOList.add(new DodelaDTO(
                item.getId(),
                item.getPocetak(),
                item.getKraj()
            ));
        }
        return new AdministrativniSluzbenikDTO(
            e.getId(),
            dodeleDTOList
        );
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ArrayList<AdministrativniSluzbenikDTO> findAll() {
        ArrayList<AdministrativniSluzbenikDTO> list = new ArrayList<>();
        for (AdministrativniSluzbenik e : administrativniSluzbenikService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<AdministrativniSluzbenikDTO> findById(@PathVariable("id") Long id) {
        Optional<AdministrativniSluzbenik> opt = administrativniSluzbenikService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<AdministrativniSluzbenikDTO> deleteById(@PathVariable("id") Long id) {
        Optional<AdministrativniSluzbenik> opt = administrativniSluzbenikService.findById(id);
        if (opt.isPresent()) {
            AdministrativniSluzbenikDTO dto = buildDTO(opt.get());
            administrativniSluzbenikService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<AdministrativniSluzbenikDTO> create(@RequestBody AdministrativniSluzbenikDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        AdministrativniSluzbenik entity = new AdministrativniSluzbenik(null);
        AdministrativniSluzbenik saved = administrativniSluzbenikService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AdministrativniSluzbenikDTO> update(@PathVariable("id") Long id, @RequestBody AdministrativniSluzbenikDTO dto) {
        Optional<AdministrativniSluzbenik> opt = administrativniSluzbenikService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        AdministrativniSluzbenik entity = opt.get();
        AdministrativniSluzbenik saved = administrativniSluzbenikService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}
