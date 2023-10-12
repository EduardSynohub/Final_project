package pl.coderslab.domain.repair_service;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;
import pl.coderslab.domain.restaurant.Restaurant;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Transactional
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
