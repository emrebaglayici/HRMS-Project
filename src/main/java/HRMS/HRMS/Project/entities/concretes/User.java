package HRMS.HRMS.Project.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue
    @Column(name ="UserId")
    private int UserId;

    @Column(name = "Password")
    private String password;

    @Column(name = "PasswordAgain")
    private String passwordAgain;

    public User() {

    }
    public User(int userId, String password, String passwordAgain) {
        UserId = userId;
        this.password = password;
        this.passwordAgain = passwordAgain;
    }


}
