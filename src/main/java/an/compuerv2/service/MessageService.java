// Importing packages
package an.compuerv2.service;

// Importing required classes
import an.compuerv2.model.Message;
import java.util.List;
import java.util.Optional;

// Class
public interface MessageService {


    // Save operation
    List<Message> finAllMessage();

    // Read operations
    Optional<Message> findIdMessage(Integer idMessage);

    Message saveMessage(Message message);

    // Update operation
    Message updateMessage(Message message);

    // Delete operation
    void deleteMessage(Integer idMessage);

}
