package userservice.org.Controller;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import userservice.org.Service.UserAuthentication.UserAuthenticationService;

@RestController
@RequestMapping("user/")
public class UserAuthenticationController {
    @Autowired
    UserAuthenticationService uas;
    @GetMapping("login/{email}/{password}")
    public ResponseEntity<Object> userLogin(@PathVariable("email") String email, @PathVariable("password") String password)
    {
        try
        {
            if(uas.login(email,password)==true)
            {
                return new ResponseEntity<Object>("LOGIN SUCCESSFUL", HttpStatus.OK);
            }
            else return new ResponseEntity<Object>("LOGIN UNSUCCESSFUL", HttpStatus.UNAUTHORIZED);
        }
        catch (AuthenticationException e){
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("logout/{email}")
    public ResponseEntity<Object> userLogout(@PathVariable("email") String email)
    {
        try
        {
            Boolean res = uas.logout(email);
            return new ResponseEntity<Object>("LOGOUT SUCCESSFUL", HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_IMPLEMENTED);
        }
    }
}
