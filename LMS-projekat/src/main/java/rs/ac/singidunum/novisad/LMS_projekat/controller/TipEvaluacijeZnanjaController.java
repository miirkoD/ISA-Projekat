package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.EvaluacijaZnanjaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.TipEvaluacijeZnanjaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.EvaluacijaZnanja;
import rs.ac.singidunum.novisad.LMS_projekat.model.TipEvaluacijeZnanja;
import rs.ac.singidunum.novisad.LMS_projekat.service.TipEvaluacijeZnanjaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/tipoviEvaluacijeZnanja")
public class TipEvaluacijeZnanjaController {

    @Autowired
    private TipEvaluacijeZnanjaService tipEvaluacijeZnanjaService;

    private TipEvaluacijeZnanjaDTO buildDTO(TipEvaluacijeZnanja e) {
        List<EvaluacijaZnanjaDTO> evaluacijeZnanjaDTOList = new ArrayList<>();
        for (EvaluacijaZnanja item : e.getEvaluacijeZnanja()) {
            evaluacijeZnanjaDTOList.add(new EvaluacijaZnanjaDTO(
                item.getId(),
                item.getPocetak(),
                item.getKraj(),
                item.getBodovi()
            ));
        }
        return new TipEvaluacijeZnanjaDTO(
            e.getId(),
            e.getNaziv(),
            evaluacijeZnanjaDTOList
        );
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ArrayList<TipEvaluacijeZnanjaDTO> findAll() {
        ArrayList<TipEvaluacijeZnanjaDTO> list = new ArrayList<>();
        for (TipEvaluacijeZnanja e : tipEvaluacijeZnanjaService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<TipEvaluacijeZnanjaDTO> findById(@PathVariable("id") Long id) {
        Optional<TipEvaluacijeZnanja> opt = tipEvaluacijeZnanjaService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<TipEvaluacijeZnanjaDTO> deleteById(@PathVariable("id") Long id) {
        Optional<TipEvaluacijeZnanja> opt = tipEvaluacijeZnanjaService.findById(id);
        if (opt.isPresent()) {
            TipEvaluacijeZnanjaDTO dto = buildDTO(opt.get());
            tipEvaluacijeZnanjaService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<TipEvaluacijeZnanjaDTO> create(@RequestBody TipEvaluacijeZnanjaDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        TipEvaluacijeZnanja entity = new TipEvaluacijeZnanja(null, dto.getNaziv());
        TipEvaluacijeZnanja saved = tipEvaluacijeZnanjaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TipEvaluacijeZnanjaDTO> update(@PathVariable("id") Long id, @RequestBody TipEvaluacijeZnanjaDTO dto) {
        Optional<TipEvaluacijeZnanja> opt = tipEvaluacijeZnanjaService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        TipEvaluacijeZnanja entity = opt.get();
        entity.setNaziv(dto.getNaziv());
        TipEvaluacijeZnanja saved = tipEvaluacijeZnanjaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}