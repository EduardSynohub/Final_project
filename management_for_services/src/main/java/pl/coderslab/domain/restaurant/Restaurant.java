package pl.coderslab.domain.restaurant;

import lombok.*;
import pl.coderslab.domain.equipment.Equipment;
import pl.coderslab.domain.repair_service.RepairService;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Transactional
@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Set<Equipment> equipments = new HashSet<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "restaurant_repairServices",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "repairService_id"))
    private List<RepairService> repairServices = new ArrayList<>();


    public void addRepairService(RepairService repairService) {
        repairServices.add(repairService);
        repairService.getRestaurants().remove(this);
    }

    public void removeRepairService(RepairService repairService) {
        repairServices.remove(repairService);
        repairService.getRestaurants().remove(this);
    }

    public void addEquipment(Equipment equipment) {
        this.equipments.add(equipment);
    }

    public void removeEquipment(Equipment equipment) {
        equipments.remove(equipment);
    }
}
