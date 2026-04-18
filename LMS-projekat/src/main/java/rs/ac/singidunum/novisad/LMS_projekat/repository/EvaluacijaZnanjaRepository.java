package rs.ac.singidunum.novisad.LMS_projekat.repository;

import rs.ac.singidunum.novisad.LMS_projekat.model.EvaluacijaZnanja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluacijaZnanjaRepository extends CrudRepository<EvaluacijaZnanja, Long> {

}