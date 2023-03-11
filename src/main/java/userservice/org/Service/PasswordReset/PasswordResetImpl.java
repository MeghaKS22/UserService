package userservice.org.Service.PasswordReset;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userservice.org.Model.UserLoginDetails;
import userservice.org.Model.UserModel;
import userservice.org.Repository.UserModelRepo;

import java.util.Date;
import java.util.Objects;
@Service
public class PasswordResetImpl implements PasswordReset{
    @Autowired
    UserModelRepo umr;
    @Override
    public Boolean resetPassword(String email, String password, String newPassword) throws AuthenticationException {
        UserModel user = umr.findByEmail(email);
        if(user==null)
        {
            throw new AuthenticationException("EMAIL ID DOES NOT EXIST");
        }
        else if(Objects.equals(user.getPasswordHash(),password)) {
            System.out.println("coming into loop");
            UserLoginDetails uld = user.getUserLoginDetails();
            if(user.getUserLoginDetails().getAccountStatus()=='I')
            {
                uld.setAccountStatus('A');
            }
            if(user.getUserLoginDetails().getAccountStatus()=='B')
            {
                throw new AuthenticationException("Account is banned hence cannot access account data");
            }
            uld.setLoginStatus(true);
            uld.setLastLogin(new Date());
            user.setUserLoginDetails(uld);
            user.setPasswordHash(newPassword);
            umr.save(user);
            return true;
        }
        else
        {
            return false;
        }
    }
}
