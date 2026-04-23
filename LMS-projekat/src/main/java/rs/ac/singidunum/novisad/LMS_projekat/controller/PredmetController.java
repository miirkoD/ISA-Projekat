package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.GodinaStudijaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.IshodDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.ObrazovniCiljDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.PredmetDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.RealizacijaPredmetaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.SadrzajPredmetaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.GodinaStudija;
import rs.ac.singidunum.novisad.LMS_projekat.model.Ishod;
import rs.ac.singidunum.novisad.LMS_projekat.model.ObrazovniCilj;
import rs.ac.singidunum.novisad.LMS_projekat.model.Predmet;
import rs.ac.singidunum.novisad.LMS_projekat.model.RealizacijaPredmeta;
import rs.ac.singidunum.novisad.LMS_projekat.model.SadrzajPredmeta;
import rs.ac.singidunum.novisad.LMS_projekat.service.GodinaStudijaService;
import rs.ac.singidunum.novisad.LMS_projekat.service.PredmetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/predmeti")
public class PredmetController {

    @Autowired
    private PredmetService predmetService;

    @Autowired
    private GodinaStudijaService godinaStudijaService;

    private PredmetDTO buildDTO(Predmet e) {
        GodinaStudijaDTO godinaStudijaDTO = new GodinaStudijaDTO(
            e.getGodinaStudija().getId(),
            e.getGodinaStudija().getNaziv()
        );
        List<SadrzajPredmetaDTO> sadrzajPredmetaDTOList = new ArrayList<>();
        for (SadrzajPredmeta item : e.getSadrzajPredmeta()) {
            sadrzajPredmetaDTOList.add(new SadrzajPredmetaDTO(
                item.getId(),
                item.getNaziv(),
                item.getOpis()
            ));
        }
        List<IshodDTO> ishodDTOList = new ArrayList<>();
        for (Ishod item : e.getIshod()) {
            ishodDTOList.add(new IshodDTO(
                item.getId(),
                item.getNaziv(),
                item.getOpis()
            ));
        }
        List<ObrazovniCiljDTO> obrazovniCiljDTOList = new ArrayList<>();
        for (ObrazovniCilj item : e.getObrazovniCilj()) {
            obrazovniCiljDTOList.add(new ObrazovniCiljDTO(
                item.getId(),
                item.getNaziv(),
                item.getOpis()
            ));
        }
        List<RealizacijaPredmetaDTO> realizacijaPredmetaDTOList = new ArrayList<>();
        for (RealizacijaPredmeta item : e.getRealizacijaPredmeta()) {
            realizacijaPredmetaDTOList.add(new RealizacijaPredmetaDTO(
                item.getId()
            ));
        }
        return new PredmetDTO(
            e.getId(),
            e.getNaziv(),
            e.getEspb(),
            e.isObavezan(),
            e.getBrojPredavanja(),
            e.getBrojVezbi(),
            e.getDrugiObliciNastave(),
            e.getIstrazivackiRad(),
            e.getBrojOstalihCasova(),
            godinaStudijaDTO,
            sadrzajPredmetaDTOList,
            ishodDTOList,
            obrazovniCiljDTOList,
            realizacijaPredmetaDTOList
        );
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ArrayList<PredmetDTO> findAll() {
        ArrayList<PredmetDTO> list = new ArrayList<>();
        for (Predmet e : predmetService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<PredmetDTO> findById(@PathVariable("id") Long id) {
        Optional<Predmet> opt = predmetService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<PredmetDTO> deleteById(@PathVariable("id") Long id) {
        Optional<Predmet> opt = predmetService.findById(id);
        if (opt.isPresent()) {
            PredmetDTO dto = buildDTO(opt.get());
            predmetService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<PredmetDTO> create(@RequestBody PredmetDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<GodinaStudija> godinaStudijaOpt = godinaStudijaService.findById(dto.getGodinaStudija().getId());
        if (!godinaStudijaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Predmet entity = new Predmet(null, dto.getNaziv(), dto.getEspb(), dto.isObavezan(), 
        		dto.getBrojPredavanja(), dto.getBrojVezbi(), dto.getDrugiObliciNastave(), 
        		dto.getIstrazivackiRad(), dto.getBrojOstalihCasova(), godinaStudijaOpt.get());
        Predmet saved = predmetService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<PredmetDTO> update(@PathVariable("id") Long id, @RequestBody PredmetDTO dto) {
        Optional<Predmet> opt = predmetService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Predmet entity = opt.get();
        entity.setNaziv(dto.getNaziv());
        entity.setEspb(dto.getEspb());
        entity.setObavezan(dto.isObavezan());
        entity.setBrojPredavanja(dto.getBrojPredavanja());
        entity.setBrojVezbi(dto.getBrojVezbi());
        entity.setDrugiObliciNastave(dto.getDrugiObliciNastave());
        entity.setIstrazivackiRad(dto.getIstrazivackiRad());
        entity.setBrojOstalihCasova(dto.getBrojOstalihCasova());
        Optional<GodinaStudija> godinaStudijaOpt = godinaStudijaService.findById(dto.getGodinaStudija().getId());
        if (!godinaStudijaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setGodinaStudija(godinaStudijaOpt.get());
        Predmet saved = predmetService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }
}