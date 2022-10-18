// Importing packages
package an.compuerv2.repository;


// Importing required classes
import an.compuerv2.model.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


// Annotation
@Repository

// Class
public interface ReservationRepository extends CrudRepository<Reservation,Integer> {

    //Reporting Methods
    List<Reservation> findAllByStartDateAfterAndDevolutionDateBefore(Date fechaA, Date fechaB);

    List<Reservation> findAllByStatus(String status);


    @Query("select c.client, COUNT(c.client) FROM Reservation AS c group by c.client order by COUNT(c.client) desc")
    List<Object[]> getTotalReservationsByClient();

}
