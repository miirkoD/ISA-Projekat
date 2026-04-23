package rs.ac.singidunum.novisad.LMS_projekat.repository;

import rs.ac.singidunum.novisad.LMS_projekat.model.Univerzitet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniverzitetRepository extends CrudRepository<Univerzitet, Long> {

}
