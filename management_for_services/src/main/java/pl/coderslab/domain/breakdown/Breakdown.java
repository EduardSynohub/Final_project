package pl.coderslab.domain.breakdown;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "breakdowns")
public class Breakdown {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    @Column(name = "date_of_notification")
    private LocalDate dateOfNotification;

    @Column(name = "date_of_arrival")
    private LocalDate dateOfArrival;
}
