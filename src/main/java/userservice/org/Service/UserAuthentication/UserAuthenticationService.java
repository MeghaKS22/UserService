package userservice.org.Service.UserAuthentication;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import userservice.org.Model.UserLoginDetails;
import userservice.org.Model.UserModel;
import userservice.org.Repository.UserModelRepo;

import java.util.Date;
import java.util.Objects;

@Service
public class UserAuthenticationService implements UserAuthentication{
    @Autowired
    UserModelRepo umr;
    @Override
    public Boolean login(String email, String password) throws AuthenticationException {
        UserModel user = umr.findByEmail(email);
        if(user==null)
        {
            throw new AuthenticationException("EMAIL ID DOES NOT EXIST");
        }
        else if(Objects.equals(user.getPasswordHash(),password)) {
            UserLoginDetails uld = user.getUserLoginDetails();
            if(user.getUserLoginDetails().getAccountStatus()=='I')
            {
                uld.setAccountStatus('A');
            }
            if(user.getUserLoginDetails().getAccountStatus()=='B')
            {
                throw new AuthenticationException("Account is banned from logging in");
            }
            uld.setLoginStatus(true);
            uld.setLastLogin(new Date());
            user.setUserLoginDetails(uld);
            umr.save(user);
            return true;
        }
        else
        {
            return false;
        }
    }
    @Override
    public Boolean logout(String email) throws AuthenticationException {
        UserModel user = umr.findByEmail(email);
        if(user==null)
        {
            throw new AuthenticationException("EMAIL ID DOES NOT EXIST");
        }
        else if(user.getUserLoginDetails().getLoginStatus()==false)
        {
            throw new AuthenticationException("USER Already Logged out");
        }
        else
        {
            UserLoginDetails uld = user.getUserLoginDetails();
            uld.setLoginStatus(false);
            user.setUserLoginDetails(uld);
            umr.save(user);
            return true;
        }
    }
}
