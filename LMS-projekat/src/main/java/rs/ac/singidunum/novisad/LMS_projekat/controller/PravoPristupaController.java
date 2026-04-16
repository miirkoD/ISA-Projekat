package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.PravoPristupaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.PravoPristupa;
import rs.ac.singidunum.novisad.LMS_projekat.service.PravoPristupaService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.RegistrovanKorisnikDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.RegistrovanKorisnik;
import rs.ac.singidunum.novisad.LMS_projekat.service.RegistrovanKorisnikService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.DatotekaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Datoteka;
import rs.ac.singidunum.novisad.LMS_projekat.service.DatotekaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/pravaPristupa")
public class PravoPristupaController {

    @Autowired
    private PravoPristupaService pravoPristupaService;

    @Autowired
    private RegistrovanKorisnikService registrovanKorisnikService;

    @Autowired
    private DatotekaService datotekaService;

    private PravoPristupaDTO buildDTO(PravoPristupa e) {
        RegistrovanKorisnikDTO korisnikDTO = new RegistrovanKorisnikDTO(
            e.getKorisnik().getId(),
            e.getKorisnik().getIme(),
            e.getKorisnik().getPrezime(),
            e.getKorisnik().getJmbg(),
            e.getKorisnik().getKorisnickoIme(),
            e.getKorisnik().getLozinka()
        );
        DatotekaDTO datotekaDTO = new DatotekaDTO(
            e.getDatoteka().getId(),
            e.getDatoteka().getNaziv(),
            e.getDatoteka().getOpis(),
            e.getDatoteka().getUrl()
        );
        return new PravoPristupaDTO(
            e.getId(),
            e.getDatumKreiranja(),
            e.getDatumBrisanja(),
            korisnikDTO,
            datotekaDTO
        );
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ArrayList<PravoPristupaDTO> findAll() {
        ArrayList<PravoPristupaDTO> list = new ArrayList<>();
        for (PravoPristupa e : pravoPristupaService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<PravoPristupaDTO> findById(@PathVariable("id") Long id) {
        Optional<PravoPristupa> opt = pravoPristupaService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<PravoPristupaDTO> deleteById(@PathVariable("id") Long id) {
        Optional<PravoPristupa> opt = pravoPristupaService.findById(id);
        if (opt.isPresent()) {
            PravoPristupaDTO dto = buildDTO(opt.get());
            pravoPristupaService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<PravoPristupaDTO> create(@RequestBody PravoPristupaDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<RegistrovanKorisnik> korisnikOpt = registrovanKorisnikService.findById(dto.getKorisnik().getId());
        if (!korisnikOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<Datoteka> datotekaOpt = datotekaService.findById(dto.getDatoteka().getId());
        if (!datotekaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        PravoPristupa entity = new PravoPristupa(null, dto.getDatumKreiranja(), dto.getDatumBrisanja(), korisnikOpt.get(), datotekaOpt.get());
        PravoPristupa saved = pravoPristupaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PravoPristupaDTO> update(@PathVariable("id") Long id, @RequestBody PravoPristupaDTO dto) {
        Optional<PravoPristupa> opt = pravoPristupaService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        PravoPristupa entity = opt.get();
        entity.setDatumKreiranja(dto.getDatumKreiranja());
        entity.setDatumBrisanja(dto.getDatumBrisanja());
        Optional<RegistrovanKorisnik> korisnikOpt = registrovanKorisnikService.findById(dto.getKorisnik().getId());
        if (!korisnikOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setKorisnik(korisnikOpt.get());
        Optional<Datoteka> datotekaOpt = datotekaService.findById(dto.getDatoteka().getId());
        if (!datotekaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setDatoteka(datotekaOpt.get());
        PravoPristupa saved = pravoPristupaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}
