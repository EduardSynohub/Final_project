package pl.coderslab.domain.equipment;

import lombok.*;


import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;

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
    @NotEmpty(message = "Pole nie powinno być puste")
    private String name;
}
