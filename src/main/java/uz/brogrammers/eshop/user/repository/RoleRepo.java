package uz.brogrammers.eshop.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.brogrammers.eshop.user.entity.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

}
