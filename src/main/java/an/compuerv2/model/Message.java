// Importing required package modules
package an.compuerv2.model;

// Importing required classes
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

// Annotations
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Message")

// Class
public class Message implements Serializable {

    //Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`idMessage`")
    private Integer idMessage;

    @Column(name = "`messageText`")
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "computer")
    @JsonIgnoreProperties({"messages","reservations"})
    private Computer computer;

    @ManyToOne
    @JoinColumn(name = "client")
    @JsonIgnoreProperties({"messages","reservations"})
    private Client client;




}
