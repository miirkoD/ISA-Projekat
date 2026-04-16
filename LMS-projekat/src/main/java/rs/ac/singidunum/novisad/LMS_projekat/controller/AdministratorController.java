package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.AdministratorDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Administrator;
import rs.ac.singidunum.novisad.LMS_projekat.service.AdministratorService;
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
@RequestMapping(path = "/api/administratori")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    private AdministratorDTO buildDTO(Administrator e) {
        List<DodelaDTO> dodeleDTOList = new ArrayList<>();
        for (Dodela item : e.getDodele()) {
            dodeleDTOList.add(new DodelaDTO(
                item.getId(),
                item.getPocetak(),
                item.getKraj()
            ));
        }
        return new AdministratorDTO(
            e.getId(),
            dodeleDTOList
        );
    }

    @RequestMapping(path = "", method =RequestMethod.GET)
    public ArrayList<AdministratorDTO> findAll() {
        ArrayList<AdministratorDTO> list = new ArrayList<>();
        for (Administrator e : administratorService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<AdministratorDTO> findById(@PathVariable("id") Long id) {
        Optional<Administrator> opt = administratorService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<AdministratorDTO> deleteById(@PathVariable("id") Long id) {
        Optional<Administrator> opt = administratorService.findById(id);
        if (opt.isPresent()) {
            AdministratorDTO dto = buildDTO(opt.get());
            administratorService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<AdministratorDTO> create(@RequestBody AdministratorDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Administrator entity = new Administrator(null);
        Administrator saved = administratorService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AdministratorDTO> update(@PathVariable("id") Long id, @RequestBody AdministratorDTO dto) {
        Optional<Administrator> opt = administratorService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Administrator entity = opt.get();
        Administrator saved = administratorService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}
