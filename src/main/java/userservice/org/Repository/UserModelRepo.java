package userservice.org.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import userservice.org.Model.UserModel;

public interface UserModelRepo extends JpaRepository<UserModel, Integer> {
    public UserModel findByEmail(String email);
}
