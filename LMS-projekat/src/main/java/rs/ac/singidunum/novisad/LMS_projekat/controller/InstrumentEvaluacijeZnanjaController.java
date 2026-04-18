package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.InstrumentEvaluacijeZnanjaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.InstrumentEvaluacijeZnanja;
import rs.ac.singidunum.novisad.LMS_projekat.service.InstrumentEvaluacijeZnanjaService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.NastavniMaterijalDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.NastavniMaterijal;
import rs.ac.singidunum.novisad.LMS_projekat.dto.EvaluacijaZnanjaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.EvaluacijaZnanja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/instrumentiEvaluacijeZnanja")
public class InstrumentEvaluacijeZnanjaController {

    @Autowired
    private InstrumentEvaluacijeZnanjaService instrumentEvaluacijeZnanjaService;

    private InstrumentEvaluacijeZnanjaDTO buildDTO(InstrumentEvaluacijeZnanja e) {
        List<NastavniMaterijalDTO> nastavniMaterijaliDTOList = new ArrayList<>();
        for (NastavniMaterijal item : e.getNastavniMaterijali()) {
            nastavniMaterijaliDTOList.add(new NastavniMaterijalDTO(
                item.getId(),
                item.getNaziv(),
                item.getOpis()
            ));
        }
        List<EvaluacijaZnanjaDTO> evaluacijaZnanjaDTOList = new ArrayList<>();
        for (EvaluacijaZnanja item : e.getEvaluacijaZnanja()) {
            evaluacijaZnanjaDTOList.add(new EvaluacijaZnanjaDTO(
                item.getId(),
                item.getPocetak(),
                item.getKraj(),
                item.getBodovi()
            ));
        }
        return new InstrumentEvaluacijeZnanjaDTO(
            e.getId(),
            e.getNaziv(),
            nastavniMaterijaliDTOList,
            evaluacijaZnanjaDTOList
        );
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ArrayList<InstrumentEvaluacijeZnanjaDTO> findAll() {
        ArrayList<InstrumentEvaluacijeZnanjaDTO> list = new ArrayList<>();
        for (InstrumentEvaluacijeZnanja e : instrumentEvaluacijeZnanjaService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<InstrumentEvaluacijeZnanjaDTO> findById(@PathVariable("id") Long id) {
        Optional<InstrumentEvaluacijeZnanja> opt = instrumentEvaluacijeZnanjaService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<InstrumentEvaluacijeZnanjaDTO> deleteById(@PathVariable("id") Long id) {
        Optional<InstrumentEvaluacijeZnanja> opt = instrumentEvaluacijeZnanjaService.findById(id);
        if (opt.isPresent()) {
            InstrumentEvaluacijeZnanjaDTO dto = buildDTO(opt.get());
            instrumentEvaluacijeZnanjaService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<InstrumentEvaluacijeZnanjaDTO> create(@RequestBody InstrumentEvaluacijeZnanjaDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        InstrumentEvaluacijeZnanja entity = new InstrumentEvaluacijeZnanja(null, dto.getNaziv());
        InstrumentEvaluacijeZnanja saved = instrumentEvaluacijeZnanjaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<InstrumentEvaluacijeZnanjaDTO> update(@PathVariable("id") Long id, @RequestBody InstrumentEvaluacijeZnanjaDTO dto) {
        Optional<InstrumentEvaluacijeZnanja> opt = instrumentEvaluacijeZnanjaService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        InstrumentEvaluacijeZnanja entity = opt.get();
        entity.setNaziv(dto.getNaziv());
        InstrumentEvaluacijeZnanja saved = instrumentEvaluacijeZnanjaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}