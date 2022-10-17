package an.compuerv2.controller;


import an.compuerv2.model.Category;
import an.compuerv2.model.Reservation;
import an.compuerv2.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
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

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
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
    public Reservation saveReservation(@RequestBody Reservation reservation) {
        return reservationService.saveReservation(reservation);
    }

    // Update operation
    @PutMapping("/update")
    public Reservation updateReservation(@RequestBody Reservation reservation) {
        return reservationService.updateReservation(reservation);
    }

    // Delete operation
    @DeleteMapping("/{idReservation}")
    public void deleteReservation(@PathVariable("idReservation")Integer idReservation) {
        reservationService.deleteReservation(idReservation);
    }



}
