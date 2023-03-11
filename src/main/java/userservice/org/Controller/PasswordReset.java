package userservice.org.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import userservice.org.Service.PasswordReset.PasswordResetImpl;

@RestController
@RequestMapping("user/reset")
public class PasswordReset {
    @Autowired
    PasswordResetImpl pri;
    @PutMapping("/{email}/{password}/")
    public ResponseEntity<Object> passwordReset(@PathVariable("email") String email, @PathVariable("password") String password, @RequestBody String newPassword)
    {
        try
        {
            if(pri.resetPassword(email,password,newPassword))
            {
                return new ResponseEntity<Object>("PASSWORD RESET SUCCESSFUL", HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<Object>("PASSWORD RESET UNSUCCESSFUL", HttpStatus.OK);
            }
        }
        catch(Exception e)
        {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_IMPLEMENTED);
        }
    }
}
