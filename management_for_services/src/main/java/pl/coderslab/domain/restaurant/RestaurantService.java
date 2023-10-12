package pl.coderslab.domain.restaurant;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {
    List<Restaurant> getAll();
    Optional<Restaurant> get(Long id);
    void create(Restaurant restaurant);
    void delete(Long id);
}
