// Importing required package modules
package an.compuerv2.model.reports;

// Importing required classes
import an.compuerv2.model.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// Annotations
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

// Class
public class TotalAndClient {

    private Long total;
    private Client client;

}
