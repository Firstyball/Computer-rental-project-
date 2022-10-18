package an.compuerv2.controller;



import an.compuerv2.model.Reservation;
import an.compuerv2.model.reports.CompletedAndCancelled;
import an.compuerv2.model.reports.TotalAndClient;
import an.compuerv2.service.ReservationService;
import an.compuerv2.service.implementation.ReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Annotations
@CrossOrigin(origins="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Reservation")
// Class
public class ReservationController {

    @Autowired
    private final ReservationService reservationService;
    private final ReservationServiceImpl reservationServiceImpl;

    public ReservationController(ReservationService reservationService, ReservationServiceImpl reservationServiceImpl) {
        this.reservationService = reservationService;
        this.reservationServiceImpl = reservationServiceImpl;
    }


    // Read operations
    @GetMapping("/all")
    public List<Reservation> finAllReservation() {
        return reservationService.finAllReservation();
    }

    @GetMapping("/all/{idReservation}")
    public Optional<Reservation> findIdReservation(@PathVariable("idReservation")Integer idReservation) {
        return reservationService.findIdReservation(idReservation);
    }

    // Save operation
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation saveReservation(@RequestBody Reservation reservation) {
        return reservationService.saveReservation(reservation);
    }

    // Update operation
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    // Delete operation
    @DeleteMapping("/{idReservation}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReservation(@PathVariable("idReservation")Integer idReservation) {
        reservationService.deleteReservation(idReservation);
    }

    //Reporting Methods
    @GetMapping("/report-dates/{fecha1}/{fecha2}")
    public List<Reservation> getReservationsBetweenDatesReport(@PathVariable("fecha1") String fecha1, @PathVariable("fecha2") String fecha2){
        return reservationServiceImpl.getReservationsBetweenDatesReport(fecha1, fecha2);
    }

    @GetMapping("/report-status")
    public CompletedAndCancelled getReservationStatusReport(){
        return reservationServiceImpl.getReservationStatusReport();
    }

    @GetMapping("/report-clients")
    public List<TotalAndClient> getTopClientsReport(){
        return reservationServiceImpl.getTopClientsReport();
    }



}
