package pl.coderslab.domain.restaurant;

import lombok.*;
import pl.coderslab.domain.equipment.Equipment;
import pl.coderslab.domain.repair_service.RepairService;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
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
    @NotNull
    @NotEmpty(message = "Pole nie powinno być puste")
    @Size(min = 1, max = 40, message = "Restauracja powinna mieć nazwę")
    private String name;
    @NotNull
    @NotEmpty(message = "Pole nie powinno być puste")
    private String address;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Equipment> equipments = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "restaurant_repairServices",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "repairService_id"))
    private Set<RepairService> repairServices = new HashSet<>();


    public void addRepairService(RepairService repairService) {
        repairServices.add(repairService);
    }

    public void removeRepairService(RepairService repairService) {
        repairServices.remove(repairService);
    }

    public void addEquipment(Equipment equipment) {
        this.equipments.add(equipment);
    }

    public void removeEquipment(Equipment equipment) {
        equipments.remove(equipment);
    }
}
