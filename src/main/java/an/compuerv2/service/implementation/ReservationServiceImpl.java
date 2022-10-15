// Importing packages
package an.compuerv2.service.implementation;

// Importing required classes
import an.compuerv2.model.Reservation;
import an.compuerv2.repository.ReservationRepository;
import an.compuerv2.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Annotation
@Service
//Implementing MessageService
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private final ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // Read operations
    @Override
    public List<Reservation> finAllReservation() {
        return (List<Reservation>) reservationRepository.findAll();
    }

    @Override
    public Optional<Reservation> findIdReservation(Integer idReservation) {
        return reservationRepository.findById(idReservation);
    }

    // Save operation
    @Override
    public Reservation saveReservation(Reservation reservation) {
        if (reservation.getIdReservation() == null) {
            return reservationRepository.save(reservation);
        } else {
            Optional<Reservation> messageFound = reservationRepository.findById(reservation.getIdReservation());
            if (messageFound.isPresent()) {
                return reservation;
            } else {
                return reservationRepository.save(reservation);
            }
        }
    }

    // Update operation
    @Override
    public Reservation updateReservation(Reservation reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservation> messageFound = reservationRepository.findById(reservation.getIdReservation());
            if (!messageFound.isEmpty()) {
                if (reservation.getStarDate() != null) {
                    messageFound.get().setStarDate(reservation.getStarDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    messageFound.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    messageFound.get().setStatus(reservation.getStatus());
                }
                return reservationRepository.save(messageFound.get());
            }
        }
        return reservation;
    }

    // Delete operation
    @Override
    public void deleteReservation(Integer idReservation) {
        reservationRepository.deleteById(idReservation);
    }
}
