package HRMS.HRMS.Project.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "company")
@AllArgsConstructor
@NoArgsConstructor
public class Company {
    @Id
    @GeneratedValue()

    @Column(name ="id")
    private int id;

    @Column(name = "company_name")
    private String company_name;

    @Column(name = "website")
    private String website;

    @Column(name="phone")
    private String phone;

    @Column(name = "login_id")
    private int login_id;


}