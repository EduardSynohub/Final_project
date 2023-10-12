package pl.coderslab.domain.repair_service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
