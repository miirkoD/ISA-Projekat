package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.SkolskaGodinaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.SkolskaGodina;
import rs.ac.singidunum.novisad.LMS_projekat.service.SkolskaGodinaService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.GodinaStudijaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.GodinaStudija;
import rs.ac.singidunum.novisad.LMS_projekat.service.GodinaStudijaService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.RealizacijaPredmetaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.RealizacijaPredmeta;
import rs.ac.singidunum.novisad.LMS_projekat.dto.UpisDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Upis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/skolskeGodine")
public class SkolskaGodinaController {

    @Autowired
    private SkolskaGodinaService skolskaGodinaService;

    @Autowired
    private GodinaStudijaService godinaStudijaService;

    private SkolskaGodinaDTO buildDTO(SkolskaGodina e) {
        GodinaStudijaDTO godinaStudijaDTO = new GodinaStudijaDTO(
            e.getGodinaStudija().getId(),
            e.getGodinaStudija().getNaziv()
        );
        List<RealizacijaPredmetaDTO> realizacijaPredmetaDTOList = new ArrayList<>();
        for (RealizacijaPredmeta item : e.getRealizacijaPredmeta()) {
            realizacijaPredmetaDTOList.add(new RealizacijaPredmetaDTO(
                item.getId()
            ));
        }
        List<UpisDTO> upisiDTOList = new ArrayList<>();
        for (Upis item : e.getUpisi()) {
            upisiDTOList.add(new UpisDTO(
                item.getId(),
                item.getBrojUpisa()
            ));
        }
        return new SkolskaGodinaDTO(
            e.getId(),
            e.getPocetak(),
            e.getKraj(),
            godinaStudijaDTO,
            realizacijaPredmetaDTOList,
            upisiDTOList
        );
    }

    @RequestMapping(path = "", method = org.springframework.web.bind.annotation.RequestMethod.GET)
    public ArrayList<SkolskaGodinaDTO> findAll() {
        ArrayList<SkolskaGodinaDTO> list = new ArrayList<>();
        for (SkolskaGodina e : skolskaGodinaService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<SkolskaGodinaDTO> findById(@PathVariable("id") Long id) {
        Optional<SkolskaGodina> opt = skolskaGodinaService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<SkolskaGodinaDTO> deleteById(@PathVariable("id") Long id) {
        Optional<SkolskaGodina> opt = skolskaGodinaService.findById(id);
        if (opt.isPresent()) {
            SkolskaGodinaDTO dto = buildDTO(opt.get());
            skolskaGodinaService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<SkolskaGodinaDTO> create(@RequestBody SkolskaGodinaDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<GodinaStudija> godinaStudijaOpt = godinaStudijaService.findById(dto.getGodinaStudija().getId());
        if (!godinaStudijaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        SkolskaGodina entity = new SkolskaGodina(null, dto.getPocetak(), dto.getKraj(), godinaStudijaOpt.get());
        SkolskaGodina saved = skolskaGodinaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<SkolskaGodinaDTO> update(@PathVariable("id") Long id, @RequestBody SkolskaGodinaDTO dto) {
        Optional<SkolskaGodina> opt = skolskaGodinaService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        SkolskaGodina entity = opt.get();
        entity.setPocetak(dto.getPocetak());
        entity.setKraj(dto.getKraj());
        Optional<GodinaStudija> godinaStudijaOpt = godinaStudijaService.findById(dto.getGodinaStudija().getId());
        if (!godinaStudijaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setGodinaStudija(godinaStudijaOpt.get());
        SkolskaGodina saved = skolskaGodinaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}
