package uz.brogrammers.eshop.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.brogrammers.eshop.user.entity.Role;
import uz.brogrammers.eshop.user.entity.RoleName;
import uz.brogrammers.eshop.user.repository.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role findByName(RoleName roleName) {
        return roleRepository.findByName(roleName)
                .orElseThrow(() -> new RuntimeException("No role found by name " + roleName.name()));
    }

}
