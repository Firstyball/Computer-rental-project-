// Importing packages
package an.compuerv2.service.implementation;

// Importing required classes
import an.compuerv2.model.Client;
import an.compuerv2.model.Reservation;
import an.compuerv2.model.reports.CompletedAndCancelled;
import an.compuerv2.model.reports.TotalAndClient;
import an.compuerv2.repository.ReservationRepository;
import an.compuerv2.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
                if (reservation.getStartDate() != null) {
                    messageFound.get().setStartDate(reservation.getStartDate());
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

    //Reporting Methods
    @Override
    public List<Reservation> getReservationBetweenDAtes(Date fechaA, Date fechaB) {
        return reservationRepository.findAllByStartDateAfterAndDevolutionDateBefore(fechaA, fechaB);
    }

    @Override
    public List<Reservation> getReservationsByStatus(String status) {
        return reservationRepository.findAllByStatus(status);
    }

    @Override
    /*
    public List<TotalAndClient> getTopClients() {
        List<TotalAndClient> respuesta = new ArrayList<>();
        List<Object[]> reporte = reservationRepository.getTotalReservationsByClient();

        for (int i = 0; i < reporte.size(); i++) {
            respuesta.add(new TotalAndClient((Long) reporte.get(i)[1], (Client) reporte.get(i)[0]));
        }
        return respuesta;
    }

     */
    public List<TotalAndClient> getTopClients() {
        List<TotalAndClient> res=new ArrayList<>();

        List<Object[]> report = reservationRepository.getTotalReservationsByClient();
        for(int i=0;i<report.size();i++) {
            res.add(new TotalAndClient((Long) report.get(i)[1], (Client)report.get(i)[0]));
        }

        return res;

    }

    public List<Reservation> getReservationsBetweenDatesReport(String fechaA, String fechaB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");

        Date a = new Date();
        Date b = new Date();
        try{
            a = parser.parse(fechaA);
            b = parser.parse(fechaB);
        }catch (ParseException exception){
            exception.printStackTrace();
        }
        if(a.before(b)){
            return getReservationBetweenDAtes(a,b);
        }else{
            return new ArrayList<>();
        }
    }

    public CompletedAndCancelled getReservationStatusReport(){
        List<Reservation> completed = getReservationsByStatus("completed");
        List<Reservation> cancelled = getReservationsByStatus("cancelled");

        int cantidadCompletadas = completed.size();
        int cantidadCanceladas = cancelled.size();

        return new CompletedAndCancelled((long)cantidadCompletadas, (long)cantidadCanceladas);
    }

    public List<TotalAndClient> getTopClientsReport(){
        return getTopClients();
    }
}
