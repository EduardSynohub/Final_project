package pl.coderslab.domain.breakdown;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.domain.equipment.Equipment;
import pl.coderslab.domain.repair_service.RepairService;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "breakdowns")
public class Breakdown {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @Column(name = "date_of_notification")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfNotification;

    @Column(name = "date_of_arrival")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfArrival;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "repair_service_id")
    private RepairService repairService;
}
