package userservice.org.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import userservice.org.Model.UserModel;
import userservice.org.Service.UserRegistration.UserRegistrationService;

@RestController
@RequestMapping("/user/registration")
public class UserRegistrationController {
    @Autowired
    UserRegistrationService userRegistrationService;
    @PostMapping("/registerUser")
    public ResponseEntity<Object> registerUser(@RequestBody UserModel user)
    {
        try
        {
            UserModel u = userRegistrationService.registration(user);
            return new ResponseEntity<Object>(u, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_IMPLEMENTED);
        }
    }
}
