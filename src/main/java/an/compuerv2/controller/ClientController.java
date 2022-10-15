// Importing packages modules
package an.compuerv2.controller;

// Importing required classes
import an.compuerv2.model.Client;
import an.compuerv2.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Annotations
@RestController
@RequestMapping("/api/Client")
public class ClientController {


    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    // Read operation
    @GetMapping("/all")
    public List<Client> finAllClient() {
        return clientService.finAllClient();
    }

    @GetMapping("/all/{idClient}")
    public Optional<Client> findIdClient(@PathVariable("idClient")Integer idClient) {
        return clientService.findIdClient(idClient);
    }

    // Save operation
    @PostMapping("/save")
    public Client saveClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    // Update operation
    @PutMapping("/update")
    public Client updateClient(@RequestBody Client client)
    {
        return clientService.updateClient(client);
    }
    // Delete operation
    @DeleteMapping("/{idClient}")
    public void deleteClient(@PathVariable("idClient")Integer idClient) {
        clientService.deleteClient(idClient);
    }

}
