package pl.coderslab.domain.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaUserService implements UserService{

    private final UserRepository userRepository;

    public JpaUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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
}
