package uz.brogrammers.eshop.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.brogrammers.eshop.user.entity.User;

import java.util.Optional;

@Repository
public interface UserReposirory extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
