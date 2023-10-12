package pl.coderslab.domain.repair_service;

import java.util.List;
import java.util.Optional;

public class JpaRepairService implements RepairServiseService{

    private final RepairServiceRepository repairServiceRepository;

    public JpaRepairService(RepairServiceRepository repairServiceRepository) {
        this.repairServiceRepository = repairServiceRepository;
    }

    @Override
    public List<RepairService> getAll() {
        return repairServiceRepository.findAll();
    }

    @Override
    public Optional<RepairService> get(Long id) {
        return repairServiceRepository.findById(id);
    }

    @Override
    public void create(RepairService repairService) {
        repairServiceRepository.save(repairService);
    }

    @Override
    public void delete(Long id) {
        repairServiceRepository.deleteById(id);
    }
}
