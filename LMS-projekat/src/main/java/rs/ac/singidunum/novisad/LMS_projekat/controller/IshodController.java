package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.IshodDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.PredmetDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Ishod;
import rs.ac.singidunum.novisad.LMS_projekat.service.IshodService;
import rs.ac.singidunum.novisad.LMS_projekat.model.Predmet;
import rs.ac.singidunum.novisad.LMS_projekat.service.PredmetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/ishodi")
public class IshodController {

    @Autowired
    private IshodService ishodService;

    @Autowired
    private PredmetService predmetService;

    private IshodDTO buildDTO(Ishod e) {
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
        return new IshodDTO(
            e.getId(),
            e.getNaziv(),
            e.getOpis(),
            predmetDTO
        );
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ArrayList<IshodDTO> findAll() {
        ArrayList<IshodDTO> list = new ArrayList<>();
        for (Ishod e : ishodService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<IshodDTO> findById(@PathVariable("id") Long id) {
        Optional<Ishod> opt = ishodService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<IshodDTO> deleteById(@PathVariable("id") Long id) {
        Optional<Ishod> opt = ishodService.findById(id);
        if (opt.isPresent()) {
            IshodDTO dto = buildDTO(opt.get());
            ishodService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<IshodDTO> create(@RequestBody IshodDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<Predmet> predmetOpt = predmetService.findById(dto.getPredmet().getId());
        if (!predmetOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Ishod entity = new Ishod(null, dto.getNaziv(), dto.getOpis(), predmetOpt.get());
        Ishod saved = ishodService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<IshodDTO> update(@PathVariable("id") Long id, @RequestBody IshodDTO dto) {
        Optional<Ishod> opt = ishodService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Ishod entity = opt.get();
        entity.setNaziv(dto.getNaziv());
        entity.setOpis(dto.getOpis());
        Optional<Predmet> predmetOpt = predmetService.findById(dto.getPredmet().getId());
        if (!predmetOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setPredmet(predmetOpt.get());
        Ishod saved = ishodService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}