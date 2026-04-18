package rs.ac.singidunum.novisad.LMS_projekat.controller;

import rs.ac.singidunum.novisad.LMS_projekat.dto.AngazovanjeDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.NastavniMaterijalDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.RealizacijaPredmetaDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.TerminNastaveDTO;
import rs.ac.singidunum.novisad.LMS_projekat.dto.TipNastaveDTO;
import rs.ac.singidunum.novisad.LMS_projekat.model.TerminNastave;
import rs.ac.singidunum.novisad.LMS_projekat.service.TerminNastaveService;
import rs.ac.singidunum.novisad.LMS_projekat.model.TipNastave;
import rs.ac.singidunum.novisad.LMS_projekat.service.TipNastaveService;
import rs.ac.singidunum.novisad.LMS_projekat.model.Angazovanje;
import rs.ac.singidunum.novisad.LMS_projekat.model.NastavniMaterijal;
import rs.ac.singidunum.novisad.LMS_projekat.service.NastavniMaterijalService;
import rs.ac.singidunum.novisad.LMS_projekat.model.RealizacijaPredmeta;
import rs.ac.singidunum.novisad.LMS_projekat.service.RealizacijaPredmetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/terminiNastave")
public class TerminNastaveController {

    @Autowired
    private TerminNastaveService terminNastaveService;

    @Autowired
    private TipNastaveService tipNastaveService;

    @Autowired
    private NastavniMaterijalService nastavniMaterijalService;

    @Autowired
    private RealizacijaPredmetaService realizacijaPredmetaService;

    private TerminNastaveDTO buildDTO(TerminNastave e) {
        TipNastaveDTO tipNastaveDTO = new TipNastaveDTO(
            e.getTipNastave().getId(),
            e.getTipNastave().getNaziv()
        );
        NastavniMaterijalDTO nastavniMaterijalDTO = new NastavniMaterijalDTO(
            e.getNastavniMaterijal().getId(),
            e.getNastavniMaterijal().getNaziv(),
            e.getNastavniMaterijal().getOpis()
        );
        RealizacijaPredmetaDTO realizacijaPredmetaDTO = new RealizacijaPredmetaDTO(
            e.getRealizacijaPredmeta().getId()
        );
        List<AngazovanjeDTO> angazovanjaDTOList = new ArrayList<>();
        for (Angazovanje item : e.getAngazovanja()) {
            angazovanjaDTOList.add(new AngazovanjeDTO(
                item.getId(),
                item.getPocetak(),
                item.getKraj()
            ));
        }
        return new TerminNastaveDTO(
            e.getId(),
            e.getPocetak(),
            e.getKraj(),
            tipNastaveDTO,
            nastavniMaterijalDTO,
            realizacijaPredmetaDTO,
            angazovanjaDTOList
        );
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public ArrayList<TerminNastaveDTO> findAll() {
        ArrayList<TerminNastaveDTO> list = new ArrayList<>();
        for (TerminNastave e : terminNastaveService.findAll())
            list.add(buildDTO(e));
        return list;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<TerminNastaveDTO> findById(@PathVariable("id") Long id) {
        Optional<TerminNastave> opt = terminNastaveService.findById(id);
        if (opt.isPresent())
            return new ResponseEntity<>(buildDTO(opt.get()), HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<TerminNastaveDTO> deleteById(@PathVariable("id") Long id) {
        Optional<TerminNastave> opt = terminNastaveService.findById(id);
        if (opt.isPresent()) {
            TerminNastaveDTO dto = buildDTO(opt.get());
            terminNastaveService.deleteById(id);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping(path = "")
    public ResponseEntity<TerminNastaveDTO> create(@RequestBody TerminNastaveDTO dto) {
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<TipNastave> tipNastaveOpt = tipNastaveService.findById(dto.getTipNastave().getId());
        if (!tipNastaveOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<NastavniMaterijal> nastavniMaterijalOpt = nastavniMaterijalService.findById(dto.getNastavniMaterijal().getId());
        if (!nastavniMaterijalOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Optional<RealizacijaPredmeta> realizacijaPredmetaOpt = realizacijaPredmetaService.findById(dto.getRealizacijaPredmeta().getId());
        if (!realizacijaPredmetaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        TerminNastave entity = new TerminNastave(null, dto.getPocetak(), dto.getKraj(), tipNastaveOpt.get(), nastavniMaterijalOpt.get(), realizacijaPredmetaOpt.get());
        TerminNastave saved = terminNastaveService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<TerminNastaveDTO> update(@PathVariable("id") Long id, @RequestBody TerminNastaveDTO dto) {
        Optional<TerminNastave> opt = terminNastaveService.findById(id);
        if (!opt.isPresent())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        if (dto.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        TerminNastave entity = opt.get();
        entity.setPocetak(dto.getPocetak());
        entity.setKraj(dto.getKraj());
        Optional<TipNastave> tipNastaveOpt = tipNastaveService.findById(dto.getTipNastave().getId());
        if (!tipNastaveOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setTipNastave(tipNastaveOpt.get());
        Optional<NastavniMaterijal> nastavniMaterijalOpt = nastavniMaterijalService.findById(dto.getNastavniMaterijal().getId());
        if (!nastavniMaterijalOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setNastavniMaterijal(nastavniMaterijalOpt.get());
        Optional<RealizacijaPredmeta> realizacijaPredmetaOpt = realizacijaPredmetaService.findById(dto.getRealizacijaPredmeta().getId());
        if (!realizacijaPredmetaOpt.isPresent())
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        entity.setRealizacijaPredmeta(realizacijaPredmetaOpt.get());
        TerminNastave saved = terminNastaveService.save(entity);
        return new ResponseEntity<>(buildDTO(saved), HttpStatus.OK);
    }

}