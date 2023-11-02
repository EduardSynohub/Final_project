package pl.coderslab.domain.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.coderslab.domain.role.RoleRepository;
import pl.coderslab.domain.role.Role;

import java.util.*;

@Service
public class JpaUserService implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public JpaUserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> get(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findByUserName(String username) {
        return userRepository.findByUsername(username);
    }

    public Long getRestaurantId(String username) {
        return userRepository.findRestaurantIdByUsername(username).getRestaurant().getId();
    }

    @Override
    public void saveUser(User user) {
        user.setEnabled(1);
        if (user.getJobTitle().equals("Kierownik restauracji")) {
            Role adminRole = roleRepository.findByName("ROLE_ADMIN");
            if (adminRole == null) {
                throw new IllegalStateException("Rola 'ADMIN' nie została odnaleziona w bazie");
            }
            user.setRoles(new HashSet<>(Arrays.asList(adminRole)));
        } else {
            Role userRole = roleRepository.findByName("ROLE_USER");
            if (userRole == null) {
                throw new IllegalStateException("Rola 'USER' nie została odnaleziona w bazie");
            }
            user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    public void updateUser(User user) {
        user.setEnabled(1);
        if (user.getJobTitle().equals("Kierownik restauracji")) {
            Role adminRole = roleRepository.findByName("ROLE_ADMIN");
            if (adminRole == null) {
                throw new IllegalStateException("Rola 'ADMIN' nie została odnaleziona w bazie");
            }
            user.setRoles(new HashSet<>(Arrays.asList(adminRole)));
        } else {
            Role userRole = roleRepository.findByName("ROLE_USER");
            if (userRole == null) {
                throw new IllegalStateException("Rola 'USER' nie została odnaleziona w bazie");
            }
            user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        }
        userRepository.save(user);
    }
}
