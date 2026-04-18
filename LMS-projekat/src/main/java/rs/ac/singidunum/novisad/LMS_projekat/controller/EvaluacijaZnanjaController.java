package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.EvaluacijaZnanjaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.InstrumentEvaluacijeZnanjaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.PolaganjeDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.RealizacijaPredmetaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.TipEvaluacijeZnanjaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.EvaluacijaZnanja;
import rs.ac.singidunum.novisad.LMS_projekat.service.EvaluacijaZnanjaService;
import rs.ac.singidunum.novisad.LMS_projekat.model.TipEvaluacijeZnanja;
import rs.ac.singidunum.novisad.LMS_projekat.service.TipEvaluacijeZnanjaService;
import rs.ac.singidunum.novisad.LMS_projekat.model.InstrumentEvaluacijeZnanja;
import rs.ac.singidunum.novisad.LMS_projekat.model.Polaganje;
import rs.ac.singidunum.novisad.LMS_projekat.service.InstrumentEvaluacijeZnanjaService;
import rs.ac.singidunum.novisad.LMS_projekat.model.RealizacijaPredmeta;
import rs.ac.singidunum.novisad.LMS_projekat.service.RealizacijaPredmetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/evaluacijeZnanja")
public class EvaluacijaZnanjaController {

    @Autowired
    private EvaluacijaZnanjaService evaluacijaZnanjaService;


    @Autowired
    private TipEvaluacijeZnanjaService tipEvaluacijeZnanjaService;

    @Autowired
    private InstrumentEvaluacijeZnanjaService instrumentEvaluacijeZnanjaService;

    @Autowired
    private RealizacijaPredmetaService realizacijaPredmetaService;

    private EvaluacijaZnanjaDTO buildDTO(EvaluacijaZnanja e) {
        TipEvaluacijeZnanjaDTO tipEvaluacijeZnanjaDTO = new TipEvaluacijeZnanjaDTO(
            e.getTipEvaluacijeZnanja().getId(),
            e.getTipEvaluacijeZnanja().getNaziv()
        );
        InstrumentEvaluacijeZnanjaDTO instrumentEvaluacijeZnanjaDTO = new InstrumentEvaluacijeZnanjaDTO(
            e.getInstrumentEvaluacijeZnanja().getId(),
            e.getInstrumentEvaluacijeZnanja().getNaziv()
        );
        RealizacijaPredmetaDTO realizacijaPredmetaDTO = new RealizacijaPredmetaDTO(
            e.getRealizacijaPredmeta().getId()
        );
        List<PolaganjeDTO> polaganjaDTOList = new ArrayList<>();
        for (Polaganje item : e.getPolaganja()) {
            polaganjaDTOList.add(new PolaganjeDTO(
                item.getId(),
                item.getBodovi(),
                item.getNapomena()
            ));
        }
        return new EvaluacijaZnanjaDTO(
            e.getId(),
            e.getPocetak(),
            e.getKraj(),
            e.getBodovi(),
            tipEvaluacijeZnanjaDTO,
            instrumentEvaluacijeZnanjaDTO,
            realizacijaPredmetaDTO,
            polaganjaDTOList
        );
    }

    @RequestMapping(path = "", method =RequestMethod.GET)
    public ArrayList<EvaluacijaZnanjaDTO> findAll() {
        ArrayList<EvaluacijaZnanjaDTO> list = new ArrayList<>();
        for (EvaluacijaZnanja e : evaluacijaZnanjaService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<EvaluacijaZnanjaDTO> findById(@PathVariable("id") Long id) {
        Optional<EvaluacijaZnanja> opt = evaluacijaZnanjaService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<EvaluacijaZnanjaDTO> deleteById(@PathVariable("id") Long id) {
        Optional<EvaluacijaZnanja> opt = evaluacijaZnanjaService.findById(id);
        if (opt.isPresent()) {
            EvaluacijaZnanjaDTO dto = buildDTO(opt.get());
            evaluacijaZnanjaService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<EvaluacijaZnanjaDTO> create(@RequestBody EvaluacijaZnanjaDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<TipEvaluacijeZnanja> tipEvaluacijeZnanjaOpt = tipEvaluacijeZnanjaService.findById(dto.getTipEvaluacijeZnanja().getId());
        if (!tipEvaluacijeZnanjaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<InstrumentEvaluacijeZnanja> instrumentEvaluacijeZnanjaOpt = instrumentEvaluacijeZnanjaService.findById(dto.getInstrumentEvaluacijeZnanja().getId());
        if (!instrumentEvaluacijeZnanjaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<RealizacijaPredmeta> realizacijaPredmetaOpt = realizacijaPredmetaService.findById(dto.getRealizacijaPredmeta().getId());
        if (!realizacijaPredmetaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        EvaluacijaZnanja entity = new EvaluacijaZnanja(null, dto.getPocetak(), dto.getKraj(), dto.getBodovi(), tipEvaluacijeZnanjaOpt.get(), instrumentEvaluacijeZnanjaOpt.get(), realizacijaPredmetaOpt.get());
        EvaluacijaZnanja saved = evaluacijaZnanjaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<EvaluacijaZnanjaDTO> update(@PathVariable("id") Long id, @RequestBody EvaluacijaZnanjaDTO dto) {
        Optional<EvaluacijaZnanja> opt = evaluacijaZnanjaService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        EvaluacijaZnanja entity = opt.get();
        entity.setPocetak(dto.getPocetak());
        entity.setKraj(dto.getKraj());
        entity.setBodovi(dto.getBodovi());
        Optional<TipEvaluacijeZnanja> tipEvaluacijeZnanjaOpt = tipEvaluacijeZnanjaService.findById(dto.getTipEvaluacijeZnanja().getId());
        if (!tipEvaluacijeZnanjaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setTipEvaluacijeZnanja(tipEvaluacijeZnanjaOpt.get());
        Optional<InstrumentEvaluacijeZnanja> instrumentEvaluacijeZnanjaOpt = instrumentEvaluacijeZnanjaService.findById(dto.getInstrumentEvaluacijeZnanja().getId());
        if (!instrumentEvaluacijeZnanjaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setInstrumentEvaluacijeZnanja(instrumentEvaluacijeZnanjaOpt.get());
        Optional<RealizacijaPredmeta> realizacijaPredmetaOpt = realizacijaPredmetaService.findById(dto.getRealizacijaPredmeta().getId());
        if (!realizacijaPredmetaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setRealizacijaPredmeta(realizacijaPredmetaOpt.get());
        EvaluacijaZnanja saved = evaluacijaZnanjaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}