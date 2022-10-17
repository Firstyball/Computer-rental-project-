// Importing required packages
package an.compuerv2.controller;

// Importing required classes
import an.compuerv2.model.Message;
import an.compuerv2.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Annotations
@CrossOrigin(origins="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Message")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    // Read operation
    @GetMapping("/all")
    public List<Message> finAllMessage() {
        return messageService.finAllMessage();
    }

    @GetMapping("/all/{idMessage}")
    public Optional<Message> findIdMessage(@PathVariable("idMessage")Integer idMessage) {
        return messageService.findIdMessage(idMessage);
    }

    // Save operation
    @PostMapping("/save")
    public Message saveMessage(@RequestBody Message message) {
        return messageService.saveMessage(message);
    }

    // Update operation
    @PutMapping("/update")
    public Message updateMessage(@RequestBody Message message)
    {
        return messageService.updateMessage(message);
    }
    // Delete operation
    @DeleteMapping("/{idMessage}")
    public void deleteMessage(@PathVariable("idMessage")Integer idMessage) {
        messageService.deleteMessage(idMessage);
    }
}
