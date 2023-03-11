package userservice.org.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import userservice.org.Model.Address;

public interface AddressRepo extends JpaRepository<Address,Integer> {
}
