package userservice.org.Service.DeactivateOrBan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userservice.org.Model.AdminUser;
import userservice.org.Model.UserModel;
import userservice.org.Repository.UserModelRepo;

import java.util.Objects;

@Service
public class DeactivateOrBanImplementation implements DeactivateOrBan{

        @Autowired
        UserModelRepo umr;
        @Override
        public Boolean banAccount(String email, String password, String email2) throws Exception {
            AdminUser au = new AdminUser();
            UserModel u = umr.findByEmail(email2);
            if(u==null)
            {
                throw new Exception("EMAIL Id does not exist");
            }
            else
            {
                if(Objects.equals(au.getEmail(),email) && Objects.equals(au.getPassword(),password)) {
                    u.getUserLoginDetails().setAccountStatus('B');
                    umr.save(u);
                    return true;
                }
                else
                {
                    throw new Exception("Authentication Failed");
                }
            }
        }
        @Override
        public Boolean deactivateAccount(String email, String password) throws Exception {
            UserModel u = umr.findByEmail(email);
            if(u==null)
            {
                throw new Exception("EMAIL Id does not exist");
            }
            else
            {
                if(Objects.equals(u.getPasswordHash(),password)) {
                    u.getUserLoginDetails().setAccountStatus('I');
                    umr.save(u);
                    return true;
                }
                else
                {
                    throw new Exception("Authentication Failed");
                }
            }
        }
    }
