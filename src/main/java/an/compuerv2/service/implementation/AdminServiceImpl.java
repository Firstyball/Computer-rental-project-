// Importing required packages
package an.compuerv2.service.implementation;

// Importing required classes
import an.compuerv2.model.Admin;
import an.compuerv2.repository.AdminRepository;
import an.compuerv2.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


//Annotation
@Service
//Implementing ComputerService
public class AdminServiceImpl implements AdminService {


    @Autowired
    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    // Read operations
    @Override
    public List<Admin> finAllAdmin() {
        return (List<Admin>) adminRepository.findAll();
    }

    @Override
    public Optional<Admin> findIdAdmin(Integer idAdmin) {
        return adminRepository.findById(idAdmin);
    }

    // Save operation
    @Override
    public Admin saveAdmin(Admin admin) {
        if(admin.getIdAdmin() == null){
            return adminRepository.save(admin);
        } else{
            Optional<Admin> adminFound = adminRepository.findById(admin.getIdAdmin());
            if(adminFound.isEmpty()){
                return adminRepository.save(admin);
            } else{
                return admin;
            }
        }
    }

    // Update operation
    @Override
    public Admin updateAdmin(Admin admin) {
        if(admin.getIdAdmin() != null){
            Optional<Admin> adminFound = adminRepository.findById(admin.getIdAdmin());
            if(!adminFound.isEmpty()){
                if(admin.getPassword() != null){
                    adminFound.get().setPassword(admin.getPassword());
                }
                if(admin.getName() != null){
                    adminFound.get().setName(admin.getName());
                }
                return adminRepository.save(adminFound.get());
            }
        }return admin;
    }

    // Delete operation
    @Override
    public void deleteAdmin(Integer idAdmin) {
        adminRepository.deleteById(idAdmin);
    }
}
