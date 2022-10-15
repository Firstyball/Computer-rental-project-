// Importing required packages
package an.compuerv2.service.implementation;

// Importing required classes
import an.compuerv2.model.Client;
import an.compuerv2.repository.ClientRepository;
import an.compuerv2.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Annotation
@Service
//Implementing ClientService
public class ClientServiceImpl implements ClientService {

    @Autowired
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    // Read operations
    @Override
    public List<Client> finAllClient() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Optional<Client> findIdClient(Integer idClient) {
        return clientRepository.findById(idClient);
    }

    // Save operation
    @Override
    public Client saveClient(Client client) {

        if (client.getIdClient() == null) {
            return clientRepository.save(client);
        } else {
            Optional<Client> clientFound = clientRepository.findById(client.getIdClient());
            if (clientFound.isEmpty()) {
                return clientRepository.save(client);
            } else {
                return client;
            }
        }

    }

    // Update operation
    @Override
    public Client updateClient(Client client) {
        if(client.getIdClient()!= null){
            Optional<Client> clientFound = clientRepository.findById(client.getIdClient());
            if(!clientFound.isEmpty()){
                if(client.getName()!=null){
                    clientFound.get().setName(client.getName());
                }
                if(client.getAge()!= null){
                    clientFound.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    clientFound.get().setPassword(client.getPassword());
                }
                return clientRepository.save(clientFound.get());
            }
        }
        return client;
    }

    @Override
    public void deleteClient(Integer idClient) {
        clientRepository.deleteById(idClient);
    }
}
