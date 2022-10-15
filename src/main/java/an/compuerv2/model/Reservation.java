// Importing required package modules
package an.compuerv2.model;

// Importing required classes
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

// Annotations
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "reservation")

// Class
public class Reservation {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`idReservation`")
    private Integer idReservation;

    @Column(name = "`starDate`")
    private Date starDate;

    @Column(name = "`devolutionDate`")
    private Date devolutionDate;

    private String status = "created";


    @ManyToOne
    @JoinColumn(name = "computer")
    @JsonIgnoreProperties("reservations")
    private Computer computer;

    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client;

    @OneToOne(cascade = {CascadeType.REMOVE},mappedBy="reservation")
    @JsonIgnoreProperties("reservation")
    private Score score;

    public Reservation() {

    }
}