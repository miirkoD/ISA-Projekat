package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.AngazovanjeDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.EvaluacijaZnanjaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.NastavniMaterijalDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.PohadjanjeDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.PredmetDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.RealizacijaPredmetaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.SkolskaGodinaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.TerminNastaveDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Angazovanje;
import rs.ac.singidunum.novisad.LMS_projekat.model.EvaluacijaZnanja;
import rs.ac.singidunum.novisad.LMS_projekat.model.NastavniMaterijal;
import rs.ac.singidunum.novisad.LMS_projekat.model.Pohadjanje;
import rs.ac.singidunum.novisad.LMS_projekat.model.Predmet;
import rs.ac.singidunum.novisad.LMS_projekat.model.RealizacijaPredmeta;
import rs.ac.singidunum.novisad.LMS_projekat.model.SkolskaGodina;
import rs.ac.singidunum.novisad.LMS_projekat.model.TerminNastave;
import rs.ac.singidunum.novisad.LMS_projekat.service.PredmetService;
import rs.ac.singidunum.novisad.LMS_projekat.service.RealizacijaPredmetaService;
import rs.ac.singidunum.novisad.LMS_projekat.service.SkolskaGodinaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/realizacijePredmeta")
public class RealizacijaPredmetaController {

    @Autowired
    private RealizacijaPredmetaService realizacijaPredmetaService;

    @Autowired
    private SkolskaGodinaService skolskaGodinaService;
    
    @Autowired
    private PredmetService predmetService;

    private RealizacijaPredmetaDTO buildDTO(RealizacijaPredmeta e) {
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
        SkolskaGodinaDTO skolskaGodinaDTO = new SkolskaGodinaDTO(
            e.getSkolskaGodina().getId(),
            e.getSkolskaGodina().getPocetak(),
            e.getSkolskaGodina().getKraj()
        );
        List<EvaluacijaZnanjaDTO> evaluacijeZnanjaDTOList = new ArrayList<>();
        for (EvaluacijaZnanja item : e.getEvaluacijeZnanja()) {
            evaluacijeZnanjaDTOList.add(new EvaluacijaZnanjaDTO(
                item.getId(),
                item.getPocetak(),
                item.getKraj(),
                item.getBodovi()
            ));
        }
        List<AngazovanjeDTO> angazovanjaDTOList = new ArrayList<>();
        for (Angazovanje item : e.getAngazovanja()) {
            angazovanjaDTOList.add(new AngazovanjeDTO(
                item.getId(),
                item.getPocetak(),
                item.getKraj()
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
        List<NastavniMaterijalDTO> nastavniMaterijaliDTOList = new ArrayList<>();
        for (NastavniMaterijal item : e.getNastavniMaterijali()) {
            nastavniMaterijaliDTOList.add(new NastavniMaterijalDTO(
                item.getId(),
                item.getNaziv(),
                item.getOpis()
            ));
        }
        List<PohadjanjeDTO> pohadjanjeDTOList = new ArrayList<>();
        for (Pohadjanje item : e.getPohadjanje()) {
            pohadjanjeDTOList.add(new PohadjanjeDTO(
                item.getId(),
                item.getKonacnaOcena()
            ));
        }
        return new RealizacijaPredmetaDTO(
            e.getId(),
            predmetDTO,
            skolskaGodinaDTO,
            evaluacijeZnanjaDTOList,
            angazovanjaDTOList,
            terminiNastaveDTOList,
            nastavniMaterijaliDTOList,
            pohadjanjeDTOList
        );
    }
    @RequestMapping(path = "", method = RequestMethod.GET)
    public ArrayList<RealizacijaPredmetaDTO> findAll() {
        ArrayList<RealizacijaPredmetaDTO> list = new ArrayList<>();
        for (RealizacijaPredmeta e : realizacijaPredmetaService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<RealizacijaPredmetaDTO> findById(@PathVariable("id") Long id) {
        Optional<RealizacijaPredmeta> opt = realizacijaPredmetaService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<RealizacijaPredmetaDTO> deleteById(@PathVariable("id") Long id) {
        Optional<RealizacijaPredmeta> opt = realizacijaPredmetaService.findById(id);
        if (opt.isPresent()) {
            RealizacijaPredmetaDTO dto = buildDTO(opt.get());
            realizacijaPredmetaService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<RealizacijaPredmetaDTO> create(@RequestBody RealizacijaPredmetaDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<Predmet> predmetOpt = predmetService.findById(dto.getPredmet().getId());
        if (!predmetOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<SkolskaGodina> skolskaGodinaOpt = skolskaGodinaService.findById(dto.getSkolskaGodina().getId());
        if (!skolskaGodinaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        RealizacijaPredmeta entity = new RealizacijaPredmeta(null, predmetOpt.get(), skolskaGodinaOpt.get());
        RealizacijaPredmeta saved = realizacijaPredmetaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }
    
    @PutMapping(path = "/{id}")
    public ResponseEntity<RealizacijaPredmetaDTO> update(@PathVariable("id") Long id, @RequestBody RealizacijaPredmetaDTO dto) {
        Optional<RealizacijaPredmeta> opt = realizacijaPredmetaService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        RealizacijaPredmeta entity = opt.get();
        Optional<Predmet> predmetOpt = predmetService.findById(dto.getPredmet().getId());
        if (!predmetOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setPredmet(predmetOpt.get());
        Optional<SkolskaGodina> skolskaGodinaOpt = skolskaGodinaService.findById(dto.getSkolskaGodina().getId());
        if (!skolskaGodinaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setSkolskaGodina(skolskaGodinaOpt.get());
        RealizacijaPredmeta saved = realizacijaPredmetaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }
}