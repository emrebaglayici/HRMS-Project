package HRMS.HRMS.Project.entities.abstracts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "user",schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
//User ,Employer  Employee tablosundaki id leri default yaptın ve generation type ı Auto Yaptın
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private int id;

    @NotNull
    @NotBlank
    @Column(name = "password")
    private String password;

    @NotNull
    @NotBlank
    @Column(name = "password_again")
    private String password_again;

    @NotNull
    @NotBlank
    @Column(name="email")
    private String email;


}
