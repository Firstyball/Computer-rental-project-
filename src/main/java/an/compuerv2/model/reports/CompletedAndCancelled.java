// Importing required package modules
package an.compuerv2.model.reports;

// Importing required classes
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
public class CompletedAndCancelled {

    private Long completed;
    private Long cancelled;

}
