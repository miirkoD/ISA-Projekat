package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.PredmetDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.SadrzajPredmetaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.SadrzajPredmeta;
import rs.ac.singidunum.novisad.LMS_projekat.service.SadrzajPredmetaService;
import rs.ac.singidunum.novisad.LMS_projekat.model.Predmet;
import rs.ac.singidunum.novisad.LMS_projekat.service.PredmetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/sadrzajiPredmeta")
public class SadrzajPredmetaController {

    @Autowired
    private SadrzajPredmetaService sadrzajPredmetaService;

    @Autowired
    private PredmetService predmetService;

    private SadrzajPredmetaDTO buildDTO(SadrzajPredmeta e) {
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
        return new SadrzajPredmetaDTO(
            e.getId(),
            e.getNaziv(),
            e.getOpis(),
            predmetDTO
        );
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ArrayList<SadrzajPredmetaDTO> findAll() {
        ArrayList<SadrzajPredmetaDTO> list = new ArrayList<>();
        for (SadrzajPredmeta e : sadrzajPredmetaService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<SadrzajPredmetaDTO> findById(@PathVariable("id") Long id) {
        Optional<SadrzajPredmeta> opt = sadrzajPredmetaService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<SadrzajPredmetaDTO> deleteById(@PathVariable("id") Long id) {
        Optional<SadrzajPredmeta> opt = sadrzajPredmetaService.findById(id);
        if (opt.isPresent()) {
            SadrzajPredmetaDTO dto = buildDTO(opt.get());
            sadrzajPredmetaService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<SadrzajPredmetaDTO> create(@RequestBody SadrzajPredmetaDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<Predmet> predmetOpt = predmetService.findById(dto.getPredmet().getId());
        if (!predmetOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        SadrzajPredmeta entity = new SadrzajPredmeta(null, dto.getNaziv(), dto.getOpis(), predmetOpt.get());
        SadrzajPredmeta saved = sadrzajPredmetaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<SadrzajPredmetaDTO> update(@PathVariable("id") Long id, @RequestBody SadrzajPredmetaDTO dto) {
        Optional<SadrzajPredmeta> opt = sadrzajPredmetaService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        SadrzajPredmeta entity = opt.get();
        entity.setNaziv(dto.getNaziv());
        entity.setOpis(dto.getOpis());
        Optional<Predmet> predmetOpt = predmetService.findById(dto.getPredmet().getId());
        if (!predmetOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setPredmet(predmetOpt.get());
        SadrzajPredmeta saved = sadrzajPredmetaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}