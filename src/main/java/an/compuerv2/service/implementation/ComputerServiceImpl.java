// Importing required packages
package an.compuerv2.service.implementation;

// Importing required classes
import an.compuerv2.model.Computer;
import an.compuerv2.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import an.compuerv2.repository.ComputerRepository;

import java.util.List;
import java.util.Optional;

//Annotation
@Service
//Implementing ComputerService
public class ComputerServiceImpl implements ComputerService {
    @Autowired
    private final ComputerRepository computerRepository;

    public ComputerServiceImpl(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    // Read operations
    @Override
    public List<Computer> finAllComputer() {
        return (List<Computer>) computerRepository.findAll();
    }

    @Override
    public Optional<Computer> findById(Integer id) {
        return computerRepository.findById(id);
    }

    // Save operation
    /*
    @Override
    public Computer saveComputer(Computer computer) {

        return computerRepository.save(computer);
    }
     */

    @Override
    public Computer saveComputer(Computer computer) {
        if (computer.getId() == null) {
            return computerRepository.save(computer);
        } else {
            Optional<Computer> computerFound = computerRepository.findById(computer.getId());
            if (computerFound.isPresent()) {
                return computer;
            } else {
                return computerRepository.save(computer);
            }
        }
    }

    // Update operation
/*
    @Override
    public Computer updateComputer(Computer computer) {
        return computerRepository.save(computer);
    }
 */
    public Computer updateComputer (Computer computer){
        if(computer.getId() != null){
            Optional<Computer> computerFound = computerRepository.findById(computer.getId());
            if(computerFound.isPresent()) {
                if (computer.getName() != null) {
                    computerFound.get().setName(computer.getName());
                }
                if (computer.getBrand() != null) {
                    computerFound.get().setBrand(computer.getBrand());
                }
                if (computer.getYear() != null) {
                    computerFound.get().setYear(computer.getYear());
                }
                if (computer.getDescription() != null) {
                    computerFound.get().setDescription(computer.getDescription());
                }
                if (computer.getCategory() != null) {
                    computerFound.get().setCategory(computer.getCategory());
                }
                computerRepository.save(computerFound.get());
                return computerFound.get();
            }else {
                return computer;
            }
        }else{
            return computer;
        }
    }

    // Delete operation
    @Override
    public void deleteComputer(Integer id) {
        computerRepository.deleteById(id);
    }













/*
    // Save operation
    @Override
    public Computer saveComputer(Computer computer)
    {
        return computerRepository.save(computer);
    }

    // Read operation
    @Override
    public List<Computer> computerList()
    {
        return (List<Computer>) computerRepository.findAll();
    }

    // Update operation
    @Override
    public Computer updateComputer(Computer computer, Integer computerId) {
        Computer depDB = computerRepository.findById(computerId).get();

        if (Objects.nonNull(computer.getName()) && !"".equalsIgnoreCase(computer.getName())) {
            depDB.setName(computer.getName());
        }

        if (Objects.nonNull(computer.getBrand()) && !"".equalsIgnoreCase(computer.getBrand())) {
            depDB.setBrand(computer.getBrand());
        }

        if (Objects.nonNull(computer.getYear())) {
            depDB.setYear(computer.getYear());
        }
        if (Objects.nonNull(computer.getDescription())) {
            depDB.setDescription(computer.getDescription());
        }

        return  computerRepository.save(depDB);

    }

    // Delete operation
    @Override
    public void deleteComputerById(Integer computerId) {
        computerRepository.deleteById(computerId);
    }
 */
}
