package pl.coderslab.domain.repair_service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairServiceRepository extends JpaRepository<RepairService, Long> {
}
