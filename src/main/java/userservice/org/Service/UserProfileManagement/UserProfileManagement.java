package userservice.org.Service.UserProfileManagement;

import userservice.org.Model.UpdatableValues;
import userservice.org.Model.UserModel;

public interface UserProfileManagement {
    public Boolean updateProfile(UpdatableValues newProfile, String email, String password) throws Exception;
}
