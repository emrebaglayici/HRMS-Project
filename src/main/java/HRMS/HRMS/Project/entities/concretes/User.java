package HRMS.HRMS.Project.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    @Column(name ="user_id")
    private int UserId;

    @Column(name = "password")
    private String password;

    @Column(name = "password_again")
    private String passwordAgain;



}
