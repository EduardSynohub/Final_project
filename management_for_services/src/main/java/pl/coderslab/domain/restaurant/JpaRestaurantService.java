package pl.coderslab.domain.restaurant;

import org.springframework.stereotype.Service;
import pl.coderslab.domain.equipment.Equipment;
import pl.coderslab.domain.equipment.JpaEquipmentService;
import pl.coderslab.domain.repair_service.JpaRepairService;
import pl.coderslab.domain.repair_service.RepairService;

import java.util.List;
import java.util.Optional;

@Service
public class JpaRestaurantService implements RestaurantService{

    private final RestaurantRepository restaurantRepository;
    private final JpaEquipmentService jpaEquipmentService;

    private final JpaRepairService jpaRepairService;

    public JpaRestaurantService(RestaurantRepository restaurantRepository, JpaEquipmentService jpaEquipmentService, JpaRepairService jpaRepairService) {
        this.restaurantRepository = restaurantRepository;
        this.jpaEquipmentService = jpaEquipmentService;
        this.jpaRepairService = jpaRepairService;
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
        List<Equipment> equipmentList = jpaEquipmentService.getAll();
        for (Equipment e : equipmentList) {
            restaurant.addEquipment(e);
        }

        List<RepairService> repairServiceList = jpaRepairService.getAll();
        for(RepairService rs : repairServiceList) {
            restaurant.addRepairService(rs);
        }
        restaurantRepository.save(restaurant);
    }

    @Override
    public void delete(Long id) {
        restaurantRepository.deleteById(id);
    }

    public void addEquipmentToRestaurant(Long equipmentId, Long restaurantID) {
        Optional<Equipment> equipmentOptional = jpaEquipmentService.get(equipmentId);
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantID);

        if(restaurantOptional.isPresent() && equipmentOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();
            Equipment equipment = equipmentOptional.get();

            restaurant.addEquipment(equipment);
            restaurantRepository.save(restaurant);
        } else {
            throw new RuntimeException("Sprzęt z ID: " + equipmentId + " nie znaleziony");
        }
    }

    public void deleteEquipmentFromRestaurant(Long equipmentId, Long restaurantID) {
        Optional<Equipment> equipmentOptional = jpaEquipmentService.get(equipmentId);
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantID);

        if(restaurantOptional.isPresent() && equipmentOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();
            Equipment equipment = equipmentOptional.get();

            restaurant.removeEquipment(equipment);
            restaurantRepository.save(restaurant);
        } else {
            throw new RuntimeException("Sprzęt z ID: " + equipmentId + " nie znaleziony");
        }
    }

    public void addRepairServiceToRestaurant(Long repairServiceId, Long restaurantId) {
        Optional<RepairService> repairServiceOptional = jpaRepairService.get(repairServiceId);
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);

        if(repairServiceOptional.isPresent() && restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();
            RepairService repairService = repairServiceOptional.get();

            restaurant.addRepairService(repairService);
            restaurantRepository.save(restaurant);
        } else {
            throw new RuntimeException("Repair service z ID" + repairServiceId + " nie znaleziony");
        }
    }

    public void deleteRepairServiceFromRestaurant(Long repairServiceId, Long restaurantId) {
        Optional<RepairService> repairServiceOptional = jpaRepairService.get(repairServiceId);
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);

        if(repairServiceOptional.isPresent() && restaurantOptional.isPresent()) {
            Restaurant restaurant = restaurantOptional.get();
            RepairService repairService = repairServiceOptional.get();

            restaurant.removeRepairService(repairService);
            restaurantRepository.save(restaurant);
        } else {
            throw new RuntimeException("Repair service z ID" + repairServiceId + " nie znaleziony");
        }
    }
}
