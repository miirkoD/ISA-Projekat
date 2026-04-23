package rs.ac.singidunum.novisad.LMS_projekat.repository;

import rs.ac.singidunum.novisad.LMS_projekat.model.AdministrativnoAngazovanje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministrativnoAngazovanjeRepository extends CrudRepository<AdministrativnoAngazovanje, Long> {

}
