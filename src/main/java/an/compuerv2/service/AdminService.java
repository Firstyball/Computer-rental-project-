// Importing packages
package an.compuerv2.service;

// Importing required classes
import an.compuerv2.model.Admin;
import java.util.List;
import java.util.Optional;

// Class
public interface AdminService {

    // Save operation
    List<Admin> finAllAdmin();

    // Read operations
    Optional<Admin> findIdAdmin (Integer idAdmin);

    Admin saveAdmin(Admin admin);

    // Update operation
    Admin updateAdmin(Admin admin);

    // Delete operation
    void deleteAdmin(Integer idAdmin);

}
