package userservice.org.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import userservice.org.Model.UpdatableValues;
import userservice.org.Model.UserModel;
import userservice.org.Service.UserProfileManagement.UserProfileManagementImpl;

@RestController
@RequestMapping("user")
public class UserProfileManagementController {
    @Autowired
    UserProfileManagementImpl upm;
    @PutMapping("/update/{email}/{password}")
    public ResponseEntity<Object> updateProfile(@PathVariable("email") String email, @PathVariable("password") String password, @RequestBody UpdatableValues newProfile)
    {
        try
        {
            if(upm.updateProfile(newProfile,email,password))
            {
                return new ResponseEntity<Object>("VALUES UPDATED SUCCESSFULLY", HttpStatus.OK);
            }
            else
            {
                return new ResponseEntity<Object>("UPDATES UNSUCCESSFUL",HttpStatus.NOT_IMPLEMENTED);
            }
        }
        catch (Exception e)
        {
            return new ResponseEntity<Object>(e.getMessage(),HttpStatus.NOT_IMPLEMENTED);
        }
    }
}
