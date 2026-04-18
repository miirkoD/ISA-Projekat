package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.RegistrovanKorisnikDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.RegistrovanKorisnik;
import rs.ac.singidunum.novisad.LMS_projekat.service.RegistrovanKorisnikService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.DodelaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Dodela;
import rs.ac.singidunum.novisad.LMS_projekat.dto.PravoPristupaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.PravoPristupa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/registrovaniKorisnici")
public class RegistrovanKorisnikController {

    @Autowired
    private RegistrovanKorisnikService registrovanKorisnikService;

    private RegistrovanKorisnikDTO buildDTO(RegistrovanKorisnik e) {
        List<DodelaDTO> dodeljeneUlogeDTOList = new ArrayList<>();
        for (Dodela item : e.getDodeljeneUloge()) {
            dodeljeneUlogeDTOList.add(new DodelaDTO(
                item.getId(),
                item.getPocetak(),
                item.getKraj()
            ));
        }
        List<DodelaDTO> izvrseneDodaleDTOList = new ArrayList<>();
        for (Dodela item : e.getIzvrseneDodale()) {
            izvrseneDodaleDTOList.add(new DodelaDTO(
                item.getId(),
                item.getPocetak(),
                item.getKraj()
            ));
        }
        List<PravoPristupaDTO> pravaDTOList = new ArrayList<>();
        for (PravoPristupa item : e.getPrava()) {
            pravaDTOList.add(new PravoPristupaDTO(
                item.getId(),
                item.getDatumKreiranja(),
                item.getDatumBrisanja()
            ));
        }
        return new RegistrovanKorisnikDTO(
            e.getId(),
            e.getIme(),
            e.getPrezime(),
            e.getJmbg(),
            e.getKorisnickoIme(),
            e.getLozinka(),
            dodeljeneUlogeDTOList,
            izvrseneDodaleDTOList,
            pravaDTOList
        );
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ArrayList<RegistrovanKorisnikDTO> findAll() {
        ArrayList<RegistrovanKorisnikDTO> list = new ArrayList<>();
        for (RegistrovanKorisnik e : registrovanKorisnikService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<RegistrovanKorisnikDTO> findById(@PathVariable("id") Long id) {
        Optional<RegistrovanKorisnik> opt = registrovanKorisnikService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<RegistrovanKorisnikDTO> deleteById(@PathVariable("id") Long id) {
        Optional<RegistrovanKorisnik> opt = registrovanKorisnikService.findById(id);
        if (opt.isPresent()) {
            RegistrovanKorisnikDTO dto = buildDTO(opt.get());
            registrovanKorisnikService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<RegistrovanKorisnikDTO> create(@RequestBody RegistrovanKorisnikDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        RegistrovanKorisnik entity = new RegistrovanKorisnik(null, dto.getIme(), dto.getPrezime(), dto.getJmbg(), dto.getKorisnickoIme(), dto.getLozinka());
        RegistrovanKorisnik saved = registrovanKorisnikService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<RegistrovanKorisnikDTO> update(@PathVariable("id") Long id, @RequestBody RegistrovanKorisnikDTO dto) {
        Optional<RegistrovanKorisnik> opt = registrovanKorisnikService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        RegistrovanKorisnik entity = opt.get();
        entity.setIme(dto.getIme());
        entity.setPrezime(dto.getPrezime());
        entity.setJmbg(dto.getJmbg());
        entity.setKorisnickoIme(dto.getKorisnickoIme());
        entity.setLozinka(dto.getLozinka());
        RegistrovanKorisnik saved = registrovanKorisnikService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}
