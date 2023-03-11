package userservice.org.Service.PermissionManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userservice.org.Model.AdminUser;
import userservice.org.Model.UserModel;
import userservice.org.Repository.UserModelRepo;

import java.util.List;
import java.util.Objects;
@Service
public class PermissionManagementImpl implements  PermissionManagement{
    @Autowired
    UserModelRepo umr;
    @Override
    public Boolean addPermission(String email, String Password, String email2, List<String> permissions) throws Exception {
        AdminUser au = new AdminUser();
        if(Objects.equals(email,au.getEmail()) && Objects.equals(Password,au.getPassword()))
        {
            UserModel um = umr.findByEmail(email2);
            if(um == null)
            {
                throw new Exception("Email Id does not exist");
            }
            else
            {
                um.getPermissions().addAll(permissions);
                umr.save(um);
                return true;
            }
        }
        else
        {
            throw new Exception("AUTHENTICATION FAILED");
        }
    }
    @Override
    public Boolean removePermission(String email, String Password, String email2, List<String> permissions) throws Exception {
        AdminUser au = new AdminUser();
        if(Objects.equals(email,au.getEmail()) && Objects.equals(Password,au.getPassword()))
        {
            UserModel um = umr.findByEmail(email2);
            if(um == null)
            {
                throw new Exception("Email Id does not exist");
            }
            else
            {
                um.getPermissions().removeAll(permissions);
                umr.save(um);
                return true;
            }
        }
        else
        {
            throw new Exception("AUTHENTICATION FAILED");
        }
    }
}
