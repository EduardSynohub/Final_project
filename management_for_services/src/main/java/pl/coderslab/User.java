package pl.coderslab;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

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
