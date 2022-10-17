// Importing packages modules
package an.compuerv2.controller;

// Importing required classes
import an.compuerv2.model.Admin;
import an.compuerv2.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Annotations
@CrossOrigin(origins="*",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Admin")
// Class
public class AdminController {

    @Autowired
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }


    // Read operations
    @GetMapping("/all")
    public List<Admin> finAllAdmin() {
        return adminService.finAllAdmin();
    }

    @GetMapping("/all/{idAdmin}")
    public Optional<Admin> findIdAdmin(@PathVariable("idAdmin")Integer idAdmin) {
        return adminService.findIdAdmin(idAdmin);
    }

    // Save operation
    @PostMapping("/save")
    public Admin saveAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }

    // Update operation
    @PutMapping("/update")
    public Admin updateAdmin(@RequestBody Admin admin) {
        return adminService.updateAdmin(admin);
    }

    // Delete operation
    @DeleteMapping("/{idAdmin}")
    public void deleteAdmin(@PathVariable("idAdmin")Integer idAdmin) {
        adminService.deleteAdmin(idAdmin);
    }

}
