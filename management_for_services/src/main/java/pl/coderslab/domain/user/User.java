package pl.coderslab.domain.user;

import lombok.*;
import pl.coderslab.domain.restaurant.Restaurant;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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

    @NotNull
    @Size(min = 3, max = 30, message = "Imię powinno mieć od 3 do 30 znaków")
    private String name;

    @NotNull
    @Size(min = 3, max = 50, message = "Nazwisko powinno mieć od 3 do 50 znaków")
    private String surname;

    @Email
    @NotNull
    private String email;

    @Column(name = "job_title")
    @NotNull
    private String jobTitle;

    @NotNull
    private String password;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;


}
