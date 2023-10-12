package pl.coderslab.domain.user;

import lombok.*;
import pl.coderslab.domain.restaurant.Restaurant;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.Email;

@Getter
@NoArgsConstructor @AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Transactional
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String name;

    @Setter
    private String surname;

    @Setter
    @Email
    private String email;

    @Setter
    @Column(name = "job_title")
    private String jobTitle;

    @Setter
    private String password;

    @Setter
    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
