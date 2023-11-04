package pl.coderslab.domain.breakdown;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import pl.coderslab.domain.equipment.Equipment;
import pl.coderslab.domain.repair_service.RepairService;
import pl.coderslab.domain.restaurant.Restaurant;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    @NotEmpty(message = "Przyda się jakiś opis problemy")
    private String description;

    @Column(name = "date_of_notification")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Wybierz datę")
    private LocalDate dateOfNotification;

    @Column(name = "date_of_arrival")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Wybierz datę")
    private LocalDate dateOfArrival;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipment_id")
    private Equipment equipment;

    @ManyToOne
    @JoinColumn(name = "repair_service_id")
    private RepairService repairService;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
