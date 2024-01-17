package uz.brogrammers.eshop.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.brogrammers.eshop.user.entity.User;
import uz.brogrammers.eshop.user.repository.UserReposirory;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserReposirory userReposirory;

    public Optional<User> findById(Integer id) {
        return userReposirory.findById(id);
    }

    public Optional<User> findByEmail(String email) {
        return userReposirory.findByEmail(email);
    }

    public User save(User user) {
        return userReposirory.save(user);
    }
}
