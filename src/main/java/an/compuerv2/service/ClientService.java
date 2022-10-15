// Importing packages
package an.compuerv2.service;

// Importing required classes
import an.compuerv2.model.Category;
import an.compuerv2.model.Client;


import java.util.List;
import java.util.Optional;

// Class
public interface ClientService {

    // Save operation
    List<Client> finAllClient();

    // Read operations
    Optional<Client> findIdClient(Integer idClient);

    Client saveClient(Client client);

    // Update operation
    Client updateClient(Client client);

    // Delete operation
    void deleteClient(Integer idClient);


}
