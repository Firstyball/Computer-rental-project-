// Importing packages
package an.compuerv2.service;

// Importing required classes
import an.compuerv2.model.Category;
import an.compuerv2.model.Reservation;

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

}
