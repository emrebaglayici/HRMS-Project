package HRMS.HRMS.Project.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user",schema = "public")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue()
    @Column(name ="id")
    private int id;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name="nationality_number")
    private String nationality_number;

    @Column(name = "date_year")
    private Date date_year;

    @GeneratedValue()
    @Column(name = "login_id")
    private int login_id;



}
