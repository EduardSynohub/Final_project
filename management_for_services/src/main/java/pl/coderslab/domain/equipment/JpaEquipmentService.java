package pl.coderslab.domain.equipment;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
    public Optional<Equipment> get(Long id) {
        return equipmentRepository.findById(id);
    }

    @Override
    public void create(Equipment equipment) {
        equipmentRepository.save(equipment);
    }

    @Override
    public void delete(Long id) {
        equipmentRepository.deleteById(id);
    }
}
