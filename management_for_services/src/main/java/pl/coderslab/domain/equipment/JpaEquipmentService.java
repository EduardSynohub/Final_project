package pl.coderslab.domain.equipment;

import java.util.List;
import java.util.Optional;

public class JpaEquipmentService implements EquipmentService{

    private final EquipmentRepository equipmentRepository;

    public JpaEquipmentService(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public List<Equipment> getAll() {
        return equipmentRepository.findAll();
    }

    @Override
    public Optional<Equipment> get(String name) {
        return equipmentRepository.findEquipmentByName(name);
    }

    @Override
    public void add(Equipment equipment) {
        equipmentRepository.save(equipment);
    }

    @Override
    public void delete(Long id) {
        equipmentRepository.deleteById(id);
    }
}
