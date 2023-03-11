package userservice.org.Service.UserProfileManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.stereotype.Service;
import userservice.org.Model.Address;
import userservice.org.Model.UpdatableValues;
import userservice.org.Model.UserModel;
import userservice.org.Repository.UserModelRepo;

import java.time.LocalDate;
import java.util.Objects;
@Service

public class UserProfileManagementImpl implements UserProfileManagement{
    @Autowired
    UserModelRepo umr;
    public Boolean updateProfile(UpdatableValues newProfile, String email, String password) throws Exception {
        UserModel u = umr.findByEmail(email);
        if(u == null)
        {
            throw new Exception("EMAIL Doesn't exist");
        }
        else
        {
            if(Objects.equals(password,u.getPasswordHash()))
            {
                u.setName(Objects.isNull(newProfile.getName())?u.getName():newProfile.getName());
                u.setPhoneNumber(Objects.isNull(newProfile.getPhoneNumber())?u.getPhoneNumber():newProfile.getPhoneNumber());
                u.setDOB(Objects.isNull(newProfile.getDob())?u.getDob():newProfile.getDob());
                if(!Objects.equals(newProfile.getGender(),'\u0000'))
                {
                    u.setGender(Objects.isNull(newProfile.getGender())?u.getGender():newProfile.getGender());
                }
                if(!Objects.isNull(newProfile.getAddress()))
                {
                    u.getAddress().setState(Objects.isNull(newProfile.getAddress().getState())?u.getAddress().getState():newProfile.getAddress().getState());
                    u.getAddress().setStreet(Objects.isNull(newProfile.getAddress().getStreet())?u.getAddress().getStreet():newProfile.getAddress().getStreet());
                    u.getAddress().setCity(Objects.isNull(newProfile.getAddress().getCity())?u.getAddress().getCity():newProfile.getAddress().getCity());
                    if(newProfile.getAddress().getZipCode()!=0) {
                        u.getAddress().setZipCode(Objects.isNull(newProfile.getAddress().getZipCode()) ? u.getAddress().getZipCode() : newProfile.getAddress().getZipCode());
                    }
                    u.getAddress().setFlatAndApartment(Objects.isNull(newProfile.getAddress().getFlatAndApartment())?u.getAddress().getFlatAndApartment():newProfile.getAddress().getFlatAndApartment());
                }
                umr.save(u);
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
