package userservice.org.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import userservice.org.Service.DeactivateOrBan.DeactivateOrBanImplementation;

@RestController
@RequestMapping("user/")
public class DeactivateOrBanController{
    @Autowired
    DeactivateOrBanImplementation dorb;
    @GetMapping("Deactivate/{email}/{password}/")
    public ResponseEntity<Object> Deactivate(@PathVariable("email") String email, @PathVariable("password") String password) throws Exception {
        try
        {
            if(dorb.deactivateAccount(email, password))
            {
                return new ResponseEntity<Object>("ACCOUNT SET TO INACTIVE SUCCESSFULLY",HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<Object>("ACCOUNT UNABLE TO SET TO INACTIVE",HttpStatus.NOT_IMPLEMENTED);
            }
        }
        catch (Exception e)
        {
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.NOT_IMPLEMENTED);
        }
    }


    @GetMapping("/Ban/{email}/{password}/{email2}")
    public ResponseEntity<Object> Ban(@PathVariable("email") String email, @PathVariable("password") String password, @PathVariable("email2") String email2) throws Exception {
        try
        {
            if(dorb.banAccount(email, password, email2))
            {
                return new ResponseEntity<Object>("ACCOUNT SET TO BANNED SUCCESSFULLY",HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<Object>("ACCOUNT UNABLE TO SET TO BAN",HttpStatus.NOT_IMPLEMENTED);
            }
        }
        catch (Exception e)
        {
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.NOT_IMPLEMENTED);
        }
    }
}
