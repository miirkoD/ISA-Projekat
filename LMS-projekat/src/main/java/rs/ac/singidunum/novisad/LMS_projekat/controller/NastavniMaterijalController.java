package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.DatotekaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.InstrumentEvaluacijeZnanjaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.NastavniMaterijalDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.RealizacijaPredmetaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.TerminNastaveDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.TipNastavnogMaterijalaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.NastavniMaterijal;
import rs.ac.singidunum.novisad.LMS_projekat.service.NastavniMaterijalService;
import rs.ac.singidunum.novisad.LMS_projekat.model.TipNastavnogMaterijala;
import rs.ac.singidunum.novisad.LMS_projekat.service.TipNastavnogMaterijalaService;
import rs.ac.singidunum.novisad.LMS_projekat.model.Datoteka;
import rs.ac.singidunum.novisad.LMS_projekat.model.InstrumentEvaluacijeZnanja;
import rs.ac.singidunum.novisad.LMS_projekat.service.InstrumentEvaluacijeZnanjaService;
import rs.ac.singidunum.novisad.LMS_projekat.model.RealizacijaPredmeta;
import rs.ac.singidunum.novisad.LMS_projekat.model.TerminNastave;
import rs.ac.singidunum.novisad.LMS_projekat.service.RealizacijaPredmetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/nastavniMaterijali")
public class NastavniMaterijalController {

    @Autowired
    private NastavniMaterijalService nastavniMaterijalService;

    @Autowired
    private TipNastavnogMaterijalaService tipNastavnogMaterijalaService;

    @Autowired
    private InstrumentEvaluacijeZnanjaService instrumentEvaluacijeZnanjaService;

    @Autowired
    private RealizacijaPredmetaService realizacijaPredmetaService;

    private NastavniMaterijalDTO buildDTO(NastavniMaterijal e) {
        TipNastavnogMaterijalaDTO tipNastavnogMaterijalaDTO = new TipNastavnogMaterijalaDTO(
            e.getTipNastavnogMaterijala().getId(),
            e.getTipNastavnogMaterijala().getNaziv()
        );
        InstrumentEvaluacijeZnanjaDTO instrumentEvaluacijeZnanjaDTO = new InstrumentEvaluacijeZnanjaDTO(
            e.getInstrumentEvaluacijeZnanja().getId(),
            e.getInstrumentEvaluacijeZnanja().getNaziv()
        );
        RealizacijaPredmetaDTO realizacijaPredmetaDTO = new RealizacijaPredmetaDTO(
            e.getRealizacijaPredmeta().getId()
        );
        List<DatotekaDTO> datotekeDTOList = new ArrayList<>();
        for (Datoteka item : e.getDatoteke()) {
            datotekeDTOList.add(new DatotekaDTO(
                item.getId(),
                item.getNaziv(),
                item.getOpis(),
                item.getUrl()
            ));
        }
        List<TerminNastaveDTO> terminiNastaveDTOList = new ArrayList<>();
        for (TerminNastave item : e.getTerminiNastave()) {
            terminiNastaveDTOList.add(new TerminNastaveDTO(
                item.getId(),
                item.getPocetak(),
                item.getKraj()
            ));
        }
        return new NastavniMaterijalDTO(
            e.getId(),
            e.getNaziv(),
            e.getOpis(),
            tipNastavnogMaterijalaDTO,
            instrumentEvaluacijeZnanjaDTO,
            realizacijaPredmetaDTO,
            datotekeDTOList,
            terminiNastaveDTOList
        );
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ArrayList<NastavniMaterijalDTO> findAll() {
        ArrayList<NastavniMaterijalDTO> list = new ArrayList<>();
        for (NastavniMaterijal e : nastavniMaterijalService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<NastavniMaterijalDTO> findById(@PathVariable("id") Long id) {
        Optional<NastavniMaterijal> opt = nastavniMaterijalService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<NastavniMaterijalDTO> deleteById(@PathVariable("id") Long id) {
        Optional<NastavniMaterijal> opt = nastavniMaterijalService.findById(id);
        if (opt.isPresent()) {
            NastavniMaterijalDTO dto = buildDTO(opt.get());
            nastavniMaterijalService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<NastavniMaterijalDTO> create(@RequestBody NastavniMaterijalDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<TipNastavnogMaterijala> tipNastavnogMaterijalaOpt = tipNastavnogMaterijalaService.findById(dto.getTipNastavnogMaterijala().getId());
        if (!tipNastavnogMaterijalaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<InstrumentEvaluacijeZnanja> instrumentEvaluacijeZnanjaOpt = instrumentEvaluacijeZnanjaService.findById(dto.getInstrumentEvaluacijeZnanja().getId());
        if (!instrumentEvaluacijeZnanjaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<RealizacijaPredmeta> realizacijaPredmetaOpt = realizacijaPredmetaService.findById(dto.getRealizacijaPredmeta().getId());
        if (!realizacijaPredmetaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        NastavniMaterijal entity = new NastavniMaterijal(null, dto.getNaziv(), dto.getOpis(), tipNastavnogMaterijalaOpt.get(), instrumentEvaluacijeZnanjaOpt.get(), realizacijaPredmetaOpt.get());
        NastavniMaterijal saved = nastavniMaterijalService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<NastavniMaterijalDTO> update(@PathVariable("id") Long id, @RequestBody NastavniMaterijalDTO dto) {
        Optional<NastavniMaterijal> opt = nastavniMaterijalService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        NastavniMaterijal entity = opt.get();
        entity.setNaziv(dto.getNaziv());
        entity.setOpis(dto.getOpis());
        Optional<TipNastavnogMaterijala> tipNastavnogMaterijalaOpt = tipNastavnogMaterijalaService.findById(dto.getTipNastavnogMaterijala().getId());
        if (!tipNastavnogMaterijalaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setTipNastavnogMaterijala(tipNastavnogMaterijalaOpt.get());
        Optional<InstrumentEvaluacijeZnanja> instrumentEvaluacijeZnanjaOpt = instrumentEvaluacijeZnanjaService.findById(dto.getInstrumentEvaluacijeZnanja().getId());
        if (!instrumentEvaluacijeZnanjaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setInstrumentEvaluacijeZnanja(instrumentEvaluacijeZnanjaOpt.get());
        Optional<RealizacijaPredmeta> realizacijaPredmetaOpt = realizacijaPredmetaService.findById(dto.getRealizacijaPredmeta().getId());
        if (!realizacijaPredmetaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setRealizacijaPredmeta(realizacijaPredmetaOpt.get());
        NastavniMaterijal saved = nastavniMaterijalService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}