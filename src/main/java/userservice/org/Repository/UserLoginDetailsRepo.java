package userservice.org.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import userservice.org.Model.UserLoginDetails;

public interface UserLoginDetailsRepo extends JpaRepository<UserLoginDetails,Integer> {
}
