package userservice.org.Service.UserAuthentication;

import org.apache.tomcat.websocket.AuthenticationException;

public interface UserAuthentication {
    public Boolean login(String email, String password) throws AuthenticationException;
    public Boolean logout(String email) throws AuthenticationException;
}
