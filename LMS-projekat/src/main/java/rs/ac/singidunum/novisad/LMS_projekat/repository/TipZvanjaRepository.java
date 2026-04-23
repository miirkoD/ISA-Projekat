package rs.ac.singidunum.novisad.LMS_projekat.repository;

import rs.ac.singidunum.novisad.LMS_projekat.model.TipZvanja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipZvanjaRepository extends CrudRepository<TipZvanja, Long> {

}
