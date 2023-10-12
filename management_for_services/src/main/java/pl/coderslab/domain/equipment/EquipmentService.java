package pl.coderslab.domain.equipment;

import java.util.List;
import java.util.Optional;

public interface EquipmentService {
    List<Equipment> getAll();
    Optional<Equipment> get(Long id);
    void create(Equipment equipment);
    void delete(Long id);
}
