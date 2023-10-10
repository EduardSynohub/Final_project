package pl.coderslab;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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
    private List<Equipment> equipments;
    @ManyToMany
    private List<RepairService> repairServices;
    @OneToMany
    private List<User> usersOfRestaurant;
}
