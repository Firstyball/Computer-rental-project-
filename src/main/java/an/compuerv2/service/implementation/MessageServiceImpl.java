// Importing packages
package an.compuerv2.service.implementation;

// Importing required classes
import an.compuerv2.model.Message;
import an.compuerv2.repository.MessageRepository;
import an.compuerv2.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//Annotation
@Service
//Implementing MessageService
public class MessageServiceImpl implements MessageService {

    @Autowired
    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    // Read operations
    @Override
    public List<Message> finAllMessage() {
        return (List<Message>) messageRepository.findAll();
    }

    @Override
    public Optional<Message> findIdMessage(Integer idMessage) {
        return messageRepository.findById(idMessage);
    }

    // Save operation
    @Override
    public Message saveMessage(Message message) {
        if (message.getIdMessage() == null) {
            return messageRepository.save(message);
        } else {
            Optional<Message> messageFound = messageRepository.findById(message.getIdMessage());
            if (messageFound.isPresent()) {
                return message;
            } else {
                return messageRepository.save(message);
            }
        }
    }

    @Override
    public Message updateMessage(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> messageFound = messageRepository.findById(message.getIdMessage());
            if (!messageFound.isEmpty()){
                if (message.getMessageText() != null) {
                    messageFound.get().setMessageText(message.getMessageText());
                }
                return messageRepository.save(messageFound.get());
            }
        }
        return message;
    }

    @Override
    public void deleteMessage(Integer idMessage) {
        messageRepository.deleteById(idMessage);
    }
}
