package pl.coderslab.domain.user;

import lombok.*;
import pl.coderslab.domain.restaurant.Restaurant;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.Email;

@Setter
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

    private String name;

    private String surname;

    @Email
    private String email;

    @Column(name = "job_title")
    private String jobTitle;

    private String password;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
