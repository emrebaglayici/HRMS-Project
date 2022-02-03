package HRMS.HRMS.Project.entities.concretes;

import HRMS.HRMS.Project.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "id",referencedColumnName = "id")
public class Employee extends User {

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    @Column(name = "nationality_number")
    private String nationality_number;

    @Column(name = "birth_year")
    private String birth_year;

}