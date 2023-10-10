package pl.coderslab;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
@ToString
@EqualsAndHashCode(of = "id")
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
    private String jobTitle;
    private String password;
    @ManyToOne
    private Restaurant restaurant;
}
