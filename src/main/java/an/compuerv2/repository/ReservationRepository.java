// Importing packages
package an.compuerv2.repository;


// Importing required classes
import an.compuerv2.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


// Annotation
@Repository

// Class
public interface ReservationRepository extends CrudRepository<Reservation,Integer> {
}
