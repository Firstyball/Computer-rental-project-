// Importing required package modules
package an.compuerv2.model;

// Importing required classes
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// Annotations
@Getter
@Setter
@Entity
@Table(name = "score")

// Class
public class Score {
    //Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idScore")
    private Integer idScore;

    @Column(name = "messageText")
    private String messageText;

    @Column(name = "Stars")
    private Integer Stars;

    @OneToOne
    @JoinColumn
    @JsonIgnoreProperties("score")
    private Reservation reservation;

}
