package pl.coderslab.domain.equipment;

import lombok.*;
import pl.coderslab.domain.breakdown.Breakdown;


import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
@Transactional
@Entity
@Table(name = "equipments")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

//    @OneToMany
//    @JoinColumn(name = "equipment_id")
//    private List<Breakdown> breakdowns = new ArrayList<>();
}
