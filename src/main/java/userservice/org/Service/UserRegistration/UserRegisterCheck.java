package userservice.org.Service.UserRegistration;

import org.hibernate.tool.schema.spi.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.ValueRef;
import userservice.org.Model.Address;
import userservice.org.Model.UserModel;
import userservice.org.Repository.UserModelRepo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class UserRegisterCheck {
    @Autowired
    UserModelRepo umr;
    public Boolean nullEmail(String email)
    {
        if(email == null) return true;
        else return false;
    }
    public Boolean emailIdExists(String email) {
        if(umr==null) return false;
        else if(umr.findByEmail(email)!=null) return true;
        else return false;
    }
    public Boolean dobEmpty(LocalDate dob)
    {
        if(dob == null) return true;
        else return false;
    }

    public Boolean addressEmpty(Address address)
    {
        if(address.getFlatAndApartment()==null || address.getStreet()== null || address.getCity() == null || address.getState() == null)
        {
            return true;
        }
        else return false;
    }
}
