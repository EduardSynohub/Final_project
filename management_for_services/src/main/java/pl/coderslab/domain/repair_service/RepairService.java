package pl.coderslab.domain.repair_service;

import lombok.*;
import pl.coderslab.domain.restaurant.Restaurant;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "repair_services")
public class RepairService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;

    @ManyToMany(mappedBy = "repairServices")
    private List<Restaurant> restaurants = new ArrayList<>();

    @Column(name = "phone_number")
    private String phoneNumber;

}
