package pl.coderslab.domain.restaurant;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaRestaurantService implements RestaurantService{

    private final RestaurantRepository restaurantRepository;

    public JpaRestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Optional<Restaurant> get(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public void create(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    @Override
    public void delete(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public void update(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }
}
