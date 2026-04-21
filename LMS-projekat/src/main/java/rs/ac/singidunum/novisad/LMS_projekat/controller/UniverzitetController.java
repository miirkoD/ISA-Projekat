package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.UniverzitetDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Univerzitet;
import rs.ac.singidunum.novisad.LMS_projekat.service.UniverzitetService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.AdresaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Adresa;
import rs.ac.singidunum.novisad.LMS_projekat.service.AdresaService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.FakultetDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Fakultet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/univerziteti")
public class UniverzitetController {

    @Autowired
    private UniverzitetService univerzitetService;

    @Autowired
    private AdresaService adresaService;

    private UniverzitetDTO buildDTO(Univerzitet e) {
        AdresaDTO adresaDTO = new AdresaDTO(
            e.getAdresa().getId(),
            e.getAdresa().getUlica(),
            e.getAdresa().getBroj()
        );
        List<FakultetDTO> fakultetiDTOList = new ArrayList<>();
        for (Fakultet item : e.getFakulteti()) {
            fakultetiDTOList.add(new FakultetDTO(
                item.getId(),
                item.getNaziv()
            ));
        }
        return new UniverzitetDTO(
            e.getId(),
            e.getNaziv(),
            e.getDatumOsnivanja(),
            adresaDTO,
            fakultetiDTOList
        );
    }

    @RequestMapping(path = "", method = org.springframework.web.bind.annotation.RequestMethod.GET)
    public ArrayList<UniverzitetDTO> findAll() {
        ArrayList<UniverzitetDTO> list = new ArrayList<>();
        for (Univerzitet e : univerzitetService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<UniverzitetDTO> findById(@PathVariable("id") Long id) {
        Optional<Univerzitet> opt = univerzitetService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<UniverzitetDTO> deleteById(@PathVariable("id") Long id) {
        Optional<Univerzitet> opt = univerzitetService.findById(id);
        if (opt.isPresent()) {
            UniverzitetDTO dto = buildDTO(opt.get());
            univerzitetService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<UniverzitetDTO> create(@RequestBody UniverzitetDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<Adresa> adresaOpt = adresaService.findById(dto.getAdresa().getId());
        if (!adresaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Univerzitet entity = new Univerzitet(null, dto.getNaziv(), dto.getDatumOsnivanja(), adresaOpt.get());
        Univerzitet saved = univerzitetService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UniverzitetDTO> update(@PathVariable("id") Long id, @RequestBody UniverzitetDTO dto) {
        Optional<Univerzitet> opt = univerzitetService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Univerzitet entity = opt.get();
        entity.setNaziv(dto.getNaziv());
        entity.setDatumOsnivanja(dto.getDatumOsnivanja());
        Optional<Adresa> adresaOpt = adresaService.findById(dto.getAdresa().getId());
        if (!adresaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setAdresa(adresaOpt.get());
        Univerzitet saved = univerzitetService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}
