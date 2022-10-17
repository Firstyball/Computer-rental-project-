// Importing packages modules
package an.compuerv2.controller;

// Importing required classes
import an.compuerv2.model.Computer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import an.compuerv2.service.ComputerService;

import java.util.List;
import java.util.Optional;

// Annotations
@CrossOrigin(origins="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Computer")
// Class
public class ComputerController {

    private final ComputerService computerService;

    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    // Read operation
    @GetMapping("/all")
    public List<Computer> finAllComputer() {
        return computerService.finAllComputer();
    }

    @GetMapping("/all/{id}")
    public Optional<Computer> findById(@PathVariable("id")Integer id) {
        return computerService.findById(id);
    }

    // Save operation
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Computer saveComputer(@RequestBody Computer computer) {
        return computerService.saveComputer(computer);
    }

    // Update operation
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Computer updateComputer(@RequestBody Computer computer)
    {
        return computerService.updateComputer(computer);
    }
    // Delete operation
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComputer(@PathVariable("id")Integer id) {
        computerService.deleteComputer(id);
    }












/*
    // Save operation
    @PostMapping("/computer")
    public Computer saveComputer(@Valid @RequestBody Computer computer)
    {
        return computerService.saveComputer(computer);
    }

    // Read operation
    @GetMapping("/computer")
    public List<Computer> findAll()
    {
        return computerService.computerList();
    }

    // Update operation
    @PutMapping("/departments/{id}")

    public Computer updateComputer (@RequestBody Computer computer, @PathVariable("id") Integer computerId)
    {
        return computerService.updateComputer(computer, computerId);
    }

    // Delete operation
    @DeleteMapping("/update")

    public String deleteComputerById(@PathVariable("id") Integer computerId)
    {
        computerService.deleteComputerById(computerId);
        return "Deleted Successfully";
    }
 */

}
