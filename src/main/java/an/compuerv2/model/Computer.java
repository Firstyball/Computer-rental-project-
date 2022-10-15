// Importing required package modules
package an.compuerv2.model;

// Importing required classes
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;

import java.io.Serializable;
import java.util.List;


// Annotations
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "computer")

// Class
public class Computer implements Serializable {
    //Attributes

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "year")
    private Integer year;

    @Column(name = "description")
    private String description;


    @ManyToOne
    @JoinColumn(name = "category")
    @JsonIgnoreProperties("computers")
    private Category category;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "computer")
    @JsonIgnoreProperties({"computer","client"})
    private List<Message> messages;

    @OneToMany(cascade = {CascadeType.PERSIST}, mappedBy = "computer")
    @JsonIgnoreProperties({"computer", "messages"})
    public List<Reservation> reservations;

    // ============== Getters & Setters ============== //
    public Computer() {

    }
}
