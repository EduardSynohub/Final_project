package pl.coderslab.domain.repair_service;

import java.util.List;
import java.util.Optional;

public interface RepairServiceService {
    List<RepairService> getAll();
    Optional<RepairService> get(Long id);
    void create(RepairService repairService);
    void delete(Long id);
}
