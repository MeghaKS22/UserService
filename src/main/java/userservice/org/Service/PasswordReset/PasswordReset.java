package userservice.org.Service.PasswordReset;

import org.apache.tomcat.websocket.AuthenticationException;

public interface PasswordReset {
    public Boolean resetPassword(String email, String password, String newPassword) throws AuthenticationException;
}
