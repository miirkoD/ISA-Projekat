package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.DodelaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Dodela;
import rs.ac.singidunum.novisad.LMS_projekat.service.DodelaService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.RegistrovanKorisnikDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.RegistrovanKorisnik;
import rs.ac.singidunum.novisad.LMS_projekat.service.RegistrovanKorisnikService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.StudentDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Student;
import rs.ac.singidunum.novisad.LMS_projekat.service.StudentService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.NastavnikDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Nastavnik;
import rs.ac.singidunum.novisad.LMS_projekat.service.NastavnikService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.AdministratorDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Administrator;
import rs.ac.singidunum.novisad.LMS_projekat.service.AdministratorService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.AdministrativniSluzbenikDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.AdministrativniSluzbenik;
import rs.ac.singidunum.novisad.LMS_projekat.service.AdministrativniSluzbenikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/dodele")
public class DodelaController {

    @Autowired
    private DodelaService dodelaService;

    @Autowired
    private RegistrovanKorisnikService registrovanKorisnikService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private NastavnikService nastavnikService;

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private AdministrativniSluzbenikService administrativniSluzbenikService;

    private DodelaDTO buildDTO(Dodela e) {
        RegistrovanKorisnikDTO korisnikDTO = new RegistrovanKorisnikDTO(
            e.getKorisnik().getId(),
            e.getKorisnik().getIme(),
            e.getKorisnik().getPrezime(),
            e.getKorisnik().getJmbg(),
            e.getKorisnik().getKorisnickoIme(),
            e.getKorisnik().getLozinka()
        );
        RegistrovanKorisnikDTO dodelioDTO = new RegistrovanKorisnikDTO(
            e.getDodelio().getId(),
            e.getDodelio().getIme(),
            e.getDodelio().getPrezime(),
            e.getDodelio().getJmbg(),
            e.getDodelio().getKorisnickoIme(),
            e.getDodelio().getLozinka()
        );
        StudentDTO studentDTO = new StudentDTO(
            e.getStudent().getId()
        );
        NastavnikDTO nastavnikDTO = new NastavnikDTO(
            e.getNastavnik().getId(),
            e.getNastavnik().getBiografija()
        );
        AdministratorDTO administratorDTO = new AdministratorDTO(
            e.getAdministrator().getId()
        );
        AdministrativniSluzbenikDTO administrativniSluzbenikDTO = new AdministrativniSluzbenikDTO(
            e.getAdministrativniSluzbenik().getId()
        );
        return new DodelaDTO(
            e.getId(),
            e.getPocetak(),
            e.getKraj(),
            korisnikDTO,
            dodelioDTO,
            studentDTO,
            nastavnikDTO,
            administratorDTO,
            administrativniSluzbenikDTO
        );
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ArrayList<DodelaDTO> findAll() {
        ArrayList<DodelaDTO> list = new ArrayList<>();
        for (Dodela e : dodelaService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<DodelaDTO> findById(@PathVariable("id") Long id) {
        Optional<Dodela> opt = dodelaService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<DodelaDTO> deleteById(@PathVariable("id") Long id) {
        Optional<Dodela> opt = dodelaService.findById(id);
        if (opt.isPresent()) {
            DodelaDTO dto = buildDTO(opt.get());
            dodelaService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<DodelaDTO> create(@RequestBody DodelaDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<RegistrovanKorisnik> korisnikOpt = registrovanKorisnikService.findById(dto.getKorisnik().getId());
        if (!korisnikOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<RegistrovanKorisnik> dodelioOpt = registrovanKorisnikService.findById(dto.getDodelio().getId());
        if (!dodelioOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<Student> studentOpt = studentService.findById(dto.getStudent().getId());
        if (!studentOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<Nastavnik> nastavnikOpt = nastavnikService.findById(dto.getNastavnik().getId());
        if (!nastavnikOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<Administrator> administratorOpt = administratorService.findById(dto.getAdministrator().getId());
        if (!administratorOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<AdministrativniSluzbenik> administrativniSluzbenikOpt = administrativniSluzbenikService.findById(dto.getAdministrativniSluzbenik().getId());
        if (!administrativniSluzbenikOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Dodela entity = new Dodela(null,korisnikOpt.get(), dodelioOpt.get(), dto.getPocetak(), dto.getKraj(), studentOpt.get(), nastavnikOpt.get(), administratorOpt.get(), administrativniSluzbenikOpt.get());
        Dodela saved = dodelaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<DodelaDTO> update(@PathVariable("id") Long id, @RequestBody DodelaDTO dto) {
        Optional<Dodela> opt = dodelaService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Dodela entity = opt.get();
        entity.setPocetak(dto.getPocetak());
        entity.setKraj(dto.getKraj());
        Optional<RegistrovanKorisnik> korisnikOpt = registrovanKorisnikService.findById(dto.getKorisnik().getId());
        if (!korisnikOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setKorisnik(korisnikOpt.get());
        Optional<RegistrovanKorisnik> dodelioOpt = registrovanKorisnikService.findById(dto.getDodelio().getId());
        if (!dodelioOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setDodelio(dodelioOpt.get());
        Optional<Student> studentOpt = studentService.findById(dto.getStudent().getId());
        if (!studentOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setStudent(studentOpt.get());
        Optional<Nastavnik> nastavnikOpt = nastavnikService.findById(dto.getNastavnik().getId());
        if (!nastavnikOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setNastavnik(nastavnikOpt.get());
        Optional<Administrator> administratorOpt = administratorService.findById(dto.getAdministrator().getId());
        if (!administratorOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setAdministrator(administratorOpt.get());
        Optional<AdministrativniSluzbenik> administrativniSluzbenikOpt = administrativniSluzbenikService.findById(dto.getAdministrativniSluzbenik().getId());
        if (!administrativniSluzbenikOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setAdministrativniSluzbenik(administrativniSluzbenikOpt.get());
        Dodela saved = dodelaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}
