package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.ObrazovniCiljDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.PredmetDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.ObrazovniCilj;
import rs.ac.singidunum.novisad.LMS_projekat.service.ObrazovniCiljService;
import rs.ac.singidunum.novisad.LMS_projekat.model.Predmet;
import rs.ac.singidunum.novisad.LMS_projekat.service.PredmetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/obrazovniCiljevi")
public class ObrazovniCiljController {

    @Autowired
    private ObrazovniCiljService obrazovniCiljService;

    @Autowired
    private PredmetService predmetService;

    private ObrazovniCiljDTO buildDTO(ObrazovniCilj e) {
        PredmetDTO predmetDTO = new PredmetDTO(
            e.getPredmet().getId(),
            e.getPredmet().getNaziv(),
            e.getPredmet().getEspb(),
            e.getPredmet().isObavezan(),
            e.getPredmet().getBrojPredavanja(),
            e.getPredmet().getBrojVezbi(),
            e.getPredmet().getDrugiObliciNastave(),
            e.getPredmet().getIstrazivackiRad(),
            e.getPredmet().getBrojOstalihCasova()
        );
        return new ObrazovniCiljDTO(
            e.getId(),
            e.getNaziv(),
            e.getOpis(),
            predmetDTO
        );
    }

    @RequestMapping(path = "", method =RequestMethod.GET)
    public ArrayList<ObrazovniCiljDTO> findAll() {
        ArrayList<ObrazovniCiljDTO> list = new ArrayList<>();
        for (ObrazovniCilj e : obrazovniCiljService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<ObrazovniCiljDTO> findById(@PathVariable("id") Long id) {
        Optional<ObrazovniCilj> opt = obrazovniCiljService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ObrazovniCiljDTO> deleteById(@PathVariable("id") Long id) {
        Optional<ObrazovniCilj> opt = obrazovniCiljService.findById(id);
        if (opt.isPresent()) {
            ObrazovniCiljDTO dto = buildDTO(opt.get());
            obrazovniCiljService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<ObrazovniCiljDTO> create(@RequestBody ObrazovniCiljDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<Predmet> predmetOpt = predmetService.findById(dto.getPredmet().getId());
        if (!predmetOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        ObrazovniCilj entity = new ObrazovniCilj(null, dto.getNaziv(), dto.getOpis(), predmetOpt.get());
        ObrazovniCilj saved = obrazovniCiljService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ObrazovniCiljDTO> update(@PathVariable("id") Long id, @RequestBody ObrazovniCiljDTO dto) {
        Optional<ObrazovniCilj> opt = obrazovniCiljService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        ObrazovniCilj entity = opt.get();
        entity.setNaziv(dto.getNaziv());
        entity.setOpis(dto.getOpis());
        Optional<Predmet> predmetOpt = predmetService.findById(dto.getPredmet().getId());
        if (!predmetOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setPredmet(predmetOpt.get());
        ObrazovniCilj saved = obrazovniCiljService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}