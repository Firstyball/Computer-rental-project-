// Importing packages
package an.compuerv2.service;

// Importing required classes
import an.compuerv2.model.Computer;

import java.util.List;
import java.util.Optional;

// Class
public interface ComputerService {

    // Save operation
    List<Computer> finAllComputer();

    // Read operations
    Optional<Computer> findById (Integer id);

    Computer saveComputer(Computer computer);

    // Update operation
    Computer updateComputer(Computer computer);

    // Delete operation
    void deleteComputer(Integer id);









    /*
    // Save operation
    Computer saveComputer(Computer computer);

    // Read operation
    List<Computer> computerList();

    // Update operation
    Computer updateComputer(Computer computer, Integer computerId);

    // Delete operation
    void deleteComputerById(Integer computerId);
    */
}
