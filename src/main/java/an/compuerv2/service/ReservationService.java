// Importing packages
package an.compuerv2.service;

// Importing required classes
import an.compuerv2.model.Category;
import an.compuerv2.model.Reservation;
import an.compuerv2.model.reports.TotalAndClient;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

// Class
public interface ReservationService {
    // Save operation
    List<Reservation> finAllReservation();

    // Read operations
    Optional<Reservation> findIdReservation (Integer idReservation);

    Reservation saveReservation(Reservation reservation);

    // Update operation
    Reservation updateReservation(Reservation reservation);

    // Delete operation
    void deleteReservation(Integer idReservation);

    //Reporting Methods
     List<Reservation> getReservationBetweenDAtes(Date fechaA, Date fechaB);

    List<Reservation> getReservationsByStatus(String status);

    List<TotalAndClient> getTopClients();

}
