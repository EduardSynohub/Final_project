package pl.coderslab.domain.user;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();
    Optional<User> get(Long id);
    void create(User user);
    void delete(Long id);
    void update(User user);
}
