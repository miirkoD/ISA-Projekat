package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.UpisDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Upis;
import rs.ac.singidunum.novisad.LMS_projekat.service.UpisService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.GodinaStudijaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.GodinaStudija;
import rs.ac.singidunum.novisad.LMS_projekat.service.GodinaStudijaService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.SkolskaGodinaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.SkolskaGodina;
import rs.ac.singidunum.novisad.LMS_projekat.service.SkolskaGodinaService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.StudentNaStudijskomProgramuDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.StudentNaStudijskomProgramu;
import rs.ac.singidunum.novisad.LMS_projekat.service.StudentNaStudijskomProgramuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/upisi")
public class UpisController {

    @Autowired
    private UpisService upisService;

    @Autowired
    private GodinaStudijaService godinaStudijaService;

    @Autowired
    private SkolskaGodinaService skolskaGodinaService;

    @Autowired
    private StudentNaStudijskomProgramuService studentNaStudijskomProgramuService;

    private UpisDTO buildDTO(Upis e) {
        GodinaStudijaDTO godinaStudijaDTO = new GodinaStudijaDTO(
            e.getGodinaStudija().getId(),
            e.getGodinaStudija().getNaziv()
        );
        SkolskaGodinaDTO skolskaGodinaDTO = new SkolskaGodinaDTO(
            e.getSkolskaGodina().getId(),
            e.getSkolskaGodina().getPocetak(),
            e.getSkolskaGodina().getKraj()
        );
        StudentNaStudijskomProgramuDTO studentNaStudijskomProgramuDTO = new StudentNaStudijskomProgramuDTO(
            e.getStudentNaStudijskomProgramu().getId(),
            e.getStudentNaStudijskomProgramu().getBrojIndeksa()
        );
        return new UpisDTO(
            e.getId(),
            e.getBrojUpisa(),
            godinaStudijaDTO,
            skolskaGodinaDTO,
            studentNaStudijskomProgramuDTO
        );
    }

    @RequestMapping(path = "", method = org.springframework.web.bind.annotation.RequestMethod.GET)
    public ArrayList<UpisDTO> findAll() {
        ArrayList<UpisDTO> list = new ArrayList<>();
        for (Upis e : upisService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<UpisDTO> findById(@PathVariable("id") Long id) {
        Optional<Upis> opt = upisService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<UpisDTO> deleteById(@PathVariable("id") Long id) {
        Optional<Upis> opt = upisService.findById(id);
        if (opt.isPresent()) {
            UpisDTO dto = buildDTO(opt.get());
            upisService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<UpisDTO> create(@RequestBody UpisDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<GodinaStudija> godinaStudijaOpt = godinaStudijaService.findById(dto.getGodinaStudija().getId());
        if (!godinaStudijaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<SkolskaGodina> skolskaGodinaOpt = skolskaGodinaService.findById(dto.getSkolskaGodina().getId());
        if (!skolskaGodinaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<StudentNaStudijskomProgramu> studentNaStudijskomProgramuOpt = studentNaStudijskomProgramuService.findById(dto.getStudentNaStudijskomProgramu().getId());
        if (!studentNaStudijskomProgramuOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Upis entity = new Upis(null, dto.getBrojUpisa(), godinaStudijaOpt.get(), skolskaGodinaOpt.get(), studentNaStudijskomProgramuOpt.get());
        Upis saved = upisService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UpisDTO> update(@PathVariable("id") Long id, @RequestBody UpisDTO dto) {
        Optional<Upis> opt = upisService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Upis entity = opt.get();
        entity.setBrojUpisa(dto.getBrojUpisa());
        Optional<GodinaStudija> godinaStudijaOpt = godinaStudijaService.findById(dto.getGodinaStudija().getId());
        if (!godinaStudijaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setGodinaStudija(godinaStudijaOpt.get());
        Optional<SkolskaGodina> skolskaGodinaOpt = skolskaGodinaService.findById(dto.getSkolskaGodina().getId());
        if (!skolskaGodinaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setSkolskaGodina(skolskaGodinaOpt.get());
        Optional<StudentNaStudijskomProgramu> studentNaStudijskomProgramuOpt = studentNaStudijskomProgramuService.findById(dto.getStudentNaStudijskomProgramu().getId());
        if (!studentNaStudijskomProgramuOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setStudentNaStudijskomProgramu(studentNaStudijskomProgramuOpt.get());
        Upis saved = upisService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}
