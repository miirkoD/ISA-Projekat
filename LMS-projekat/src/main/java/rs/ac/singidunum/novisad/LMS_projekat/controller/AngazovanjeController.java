package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.AngazovanjeDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.NastavnikDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.RealizacijaPredmetaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.TerminNastaveDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.TipAngazovanjaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Angazovanje;
import rs.ac.singidunum.novisad.LMS_projekat.model.Nastavnik;
import rs.ac.singidunum.novisad.LMS_projekat.model.RealizacijaPredmeta;
import rs.ac.singidunum.novisad.LMS_projekat.model.TerminNastave;
import rs.ac.singidunum.novisad.LMS_projekat.model.TipAngazovanja;
import rs.ac.singidunum.novisad.LMS_projekat.service.AngazovanjeService;
import rs.ac.singidunum.novisad.LMS_projekat.service.NastavnikService;
import rs.ac.singidunum.novisad.LMS_projekat.service.RealizacijaPredmetaService;
import rs.ac.singidunum.novisad.LMS_projekat.service.TerminNastaveService;
import rs.ac.singidunum.novisad.LMS_projekat.service.TipAngazovanjaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/angazovanja")
public class AngazovanjeController {

    @Autowired
    private AngazovanjeService angazovanjeService;


    @Autowired
    private NastavnikService nastavnikService;
    
    @Autowired
    private TipAngazovanjaService tipAngazovanjaService;
    
    @Autowired
    private TerminNastaveService terminNastaveService;
    
    @Autowired
    private RealizacijaPredmetaService realizacijaPredmetaService;

    private AngazovanjeDTO buildDTO(Angazovanje e) {
        TipAngazovanjaDTO tipAngazovanjaDTO = new TipAngazovanjaDTO(
            e.getTipAngazovanja().getId(),
            e.getTipAngazovanja().getNaziv()
        );
        NastavnikDTO nastavnikDTO = new NastavnikDTO(
            e.getNastavnik().getId(),
            e.getNastavnik().getBiografija()
        );
        TerminNastaveDTO terminNastaveDTO = new TerminNastaveDTO(
            e.getTerminNastave().getId(),
            e.getTerminNastave().getPocetak(),
            e.getTerminNastave().getKraj()
        );
        RealizacijaPredmetaDTO realizacijaPredmetaDTO = new RealizacijaPredmetaDTO(
            e.getRealizacijaPredmeta().getId()
        );
        return new AngazovanjeDTO(
            e.getId(),
            e.getPocetak(),
            e.getKraj(),
            tipAngazovanjaDTO,
            nastavnikDTO,
            terminNastaveDTO,
            realizacijaPredmetaDTO
        );
    }

    @RequestMapping(path = "", method =RequestMethod.GET)
    public ArrayList<AngazovanjeDTO> findAll() {
        ArrayList<AngazovanjeDTO> list = new ArrayList<>();
        for (Angazovanje e : angazovanjeService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<AngazovanjeDTO> findById(@PathVariable("id") Long id) {
        Optional<Angazovanje> opt = angazovanjeService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<AngazovanjeDTO> deleteById(@PathVariable("id") Long id) {
        Optional<Angazovanje> opt = angazovanjeService.findById(id);
        if (opt.isPresent()) {
            AngazovanjeDTO dto = buildDTO(opt.get());
            angazovanjeService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<AngazovanjeDTO> create(@RequestBody AngazovanjeDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<TipAngazovanja> tipAngazovanjaOpt = tipAngazovanjaService.findById(dto.getTipAngazovanja().getId());
        if (!tipAngazovanjaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<Nastavnik> nastavnikOpt = nastavnikService.findById(dto.getNastavnik().getId());
        if (!nastavnikOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<TerminNastave> terminNastaveOpt = terminNastaveService.findById(dto.getTerminNastave().getId());
        if (!terminNastaveOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<RealizacijaPredmeta> realizacijaPredmetaOpt = realizacijaPredmetaService.findById(dto.getRealizacijaPredmeta().getId());
        if (!realizacijaPredmetaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Angazovanje entity = new Angazovanje(null, dto.getPocetak(), dto.getKraj(), tipAngazovanjaOpt.get(), nastavnikOpt.get(), terminNastaveOpt.get(), realizacijaPredmetaOpt.get());
        Angazovanje saved = angazovanjeService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AngazovanjeDTO> update(@PathVariable("id") Long id, @RequestBody AngazovanjeDTO dto) {
        Optional<Angazovanje> opt = angazovanjeService.findById(id);
        if (!opt.isPresent()) {
        	 if (dto.getId() != null)
                 return new ResponseEntity<AngazovanjeDTO>(HttpStatus.BAD_REQUEST);
        }       
        Angazovanje entity = opt.get();
        entity.setPocetak(dto.getPocetak());
        entity.setKraj(dto.getKraj());
        
        Optional<TipAngazovanja> tipAngazovanjaOpt = tipAngazovanjaService.findById(dto.getTipAngazovanja().getId());
        if (!tipAngazovanjaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setTipAngazovanja(tipAngazovanjaOpt.get());
        
        Optional<Nastavnik> nastavnikOpt = nastavnikService.findById(dto.getNastavnik().getId());
        if (!nastavnikOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setNastavnik(nastavnikOpt.get());
        
        Optional<TerminNastave> terminNastaveOpt = terminNastaveService.findById(dto.getTerminNastave().getId());
        if (!terminNastaveOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setTerminNastave(terminNastaveOpt.get());
        
        Optional<RealizacijaPredmeta> realizacijaPredmetaOpt = realizacijaPredmetaService.findById(dto.getRealizacijaPredmeta().getId());
        if (!realizacijaPredmetaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setRealizacijaPredmeta(realizacijaPredmetaOpt.get());
        
        Angazovanje saved = angazovanjeService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}