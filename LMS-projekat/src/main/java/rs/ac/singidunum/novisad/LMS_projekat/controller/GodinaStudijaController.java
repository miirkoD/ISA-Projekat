package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.GodinaStudijaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.GodinaStudija;
import rs.ac.singidunum.novisad.LMS_projekat.service.GodinaStudijaService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.StudijskiProgramDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.StudijskiProgram;
import rs.ac.singidunum.novisad.LMS_projekat.service.StudijskiProgramService;
import rs.ac.singidunum.novisad.LMS_projekat.dto.SkolskaGodinaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.SkolskaGodina;
import rs.ac.singidunum.novisad.LMS_projekat.dto.PredmetDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.Predmet;
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
@RequestMapping(path = "/api/godineStudija")
public class GodinaStudijaController {

    @Autowired
    private GodinaStudijaService godinaStudijaService;

    @Autowired
    private StudijskiProgramService studijskiProgramService;

    private GodinaStudijaDTO buildDTO(GodinaStudija e) {
        StudijskiProgramDTO studijskiProgramDTO = new StudijskiProgramDTO(
            e.getStudijskiProgram().getId(),
            e.getStudijskiProgram().getNaziv()
        );
        List<SkolskaGodinaDTO> skolskaGodinaDTOList = new ArrayList<>();
        for (SkolskaGodina item : e.getSkolskaGodina()) {
            skolskaGodinaDTOList.add(new SkolskaGodinaDTO(
                item.getId(),
                item.getPocetak(),
                item.getKraj()
            ));
        }
        List<PredmetDTO> predmetiDTOList = new ArrayList<>();
        for (Predmet item : e.getPredmeti()) {
            predmetiDTOList.add(new PredmetDTO(
                item.getId(),
                item.getNaziv(),
                item.getEspb(),
                item.isObavezan(),
                item.getBrojPredavanja(),
                item.getBrojVezbi(),
                item.getDrugiObliciNastave(),
                item.getIstrazivackiRad(),
                item.getBrojOstalihCasova()
            ));
        }
        List<UpisDTO> upisiDTOList = new ArrayList<>();
        for (Upis item : e.getUpisi()) {
            upisiDTOList.add(new UpisDTO(
                item.getId(),
                item.getBrojUpisa()
            ));
        }
        return new GodinaStudijaDTO(
            e.getId(),
            e.getNaziv(),
            studijskiProgramDTO,
            skolskaGodinaDTOList,
            predmetiDTOList,
            upisiDTOList
        );
    }

    @RequestMapping(path = "", method = org.springframework.web.bind.annotation.RequestMethod.GET)
    public ArrayList<GodinaStudijaDTO> findAll() {
        ArrayList<GodinaStudijaDTO> list = new ArrayList<>();
        for (GodinaStudija e : godinaStudijaService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<GodinaStudijaDTO> findById(@PathVariable("id") Long id) {
        Optional<GodinaStudija> opt = godinaStudijaService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<GodinaStudijaDTO> deleteById(@PathVariable("id") Long id) {
        Optional<GodinaStudija> opt = godinaStudijaService.findById(id);
        if (opt.isPresent()) {
            GodinaStudijaDTO dto = buildDTO(opt.get());
            godinaStudijaService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<GodinaStudijaDTO> create(@RequestBody GodinaStudijaDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<StudijskiProgram> studijskiProgramOpt = studijskiProgramService.findById(dto.getStudijskiProgram().getId());
        if (!studijskiProgramOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        GodinaStudija entity = new GodinaStudija(null, dto.getNaziv(), studijskiProgramOpt.get());
        GodinaStudija saved = godinaStudijaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<GodinaStudijaDTO> update(@PathVariable("id") Long id, @RequestBody GodinaStudijaDTO dto) {
        Optional<GodinaStudija> opt = godinaStudijaService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        GodinaStudija entity = opt.get();
        entity.setNaziv(dto.getNaziv());
        Optional<StudijskiProgram> studijskiProgramOpt = studijskiProgramService.findById(dto.getStudijskiProgram().getId());
        if (!studijskiProgramOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setStudijskiProgram(studijskiProgramOpt.get());
        GodinaStudija saved = godinaStudijaService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}
