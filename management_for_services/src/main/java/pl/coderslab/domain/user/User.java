package pl.coderslab.domain.user;

import lombok.*;
import pl.coderslab.domain.role.Role;
import pl.coderslab.domain.restaurant.Restaurant;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor @AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Pole nie powinno być puste")
    @Size(min = 3, max = 30, message = "Imię powinno mieć od 3 do 30 znaków")
    private String name;

    @NotEmpty(message = "Pole nie powinno być puste")
    @Size(min = 3, max = 50, message = "Nazwisko powinno mieć od 3 do 50 znaków")
    private String surname;

    @Pattern(regexp = "^User-[A-Za-z]\\.[A-Za-z]+$", message = "Niepoprawny format loginu. Przykład: User-J.Kowalski")
    @Column(unique = true)
    private String username;

    @Column(name = "job_title")
    @NotEmpty(message = "Pole nie powinno być puste")
    @Size(min = 1, max = 50, message = "Nazwa stanowiska powinna być w przedziale od 1 do 50 znaków")
    private String jobTitle;

    @NotNull(message = "")
    private String password;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    private int enabled;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
