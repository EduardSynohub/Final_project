package pl.coderslab.domain.repair_service;

import lombok.*;
import pl.coderslab.domain.restaurant.Restaurant;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "repair_services")
public class RepairService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Pole nie powinno być puste")
    @Column(unique = true)
    private String name;

    @NotEmpty(message = "Pole nie powinno być puste")
    private String address;

    @ManyToMany(mappedBy = "repairServices")
    private List<Restaurant> restaurants = new ArrayList<>();

    @Column(name = "phone_number", unique = true)
    @NotEmpty(message = "Pole nie powinno być puste")
    @Size(min = 9, max = 9, message = "Przykładowy numer telefonu: 123456789")
    @Pattern(regexp = "^\\d{9}$", message = "Powinno być dokładnie 9 liczb")
    private String phoneNumber;

    private String description;
}
