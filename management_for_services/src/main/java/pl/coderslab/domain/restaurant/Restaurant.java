package pl.coderslab.domain.restaurant;

import lombok.*;
import pl.coderslab.domain.equipment.Equipment;
import pl.coderslab.domain.repair_service.RepairService;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "restaurants")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    @ManyToMany
    private List<Equipment> equipments = new ArrayList<>();

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
}
