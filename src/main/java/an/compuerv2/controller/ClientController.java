// Importing packages modules
package an.compuerv2.controller;

// Importing required classes
import an.compuerv2.model.Client;
import an.compuerv2.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Annotations
@CrossOrigin(origins="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
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
    @ResponseStatus(HttpStatus.CREATED)
    public Client saveClient(@RequestBody Client client) {
        return clientService.saveClient(client);
    }

    // Update operation
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client updateClient(@RequestBody Client client)
    {
        return clientService.updateClient(client);
    }
    // Delete operation
    @DeleteMapping("/{idClient}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClient(@PathVariable("idClient")Integer idClient) {
        clientService.deleteClient(idClient);
    }


}
