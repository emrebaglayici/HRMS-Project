package HRMS.HRMS.Project.entities.concretes;

import HRMS.HRMS.Project.entities.abstracts.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employee"})
@PrimaryKeyJoinColumn(name = "id",referencedColumnName = "id")
public class Employee extends User {

    @NotNull
    @NotBlank
    @Column(name = "first_name")
    private String first_name;

    @NotNull
    @NotBlank
    @Column(name = "last_name")
    private String last_name;

    @NotNull
    @NotBlank
    @Column(name = "nationality_number")
    private String nationality_number;

//    @Column(name = "birth_year")
//    private String birth_year;


    @JsonFormat(pattern = "yyyy")
    @Column(name = "birth_year")
    private Date birth_year;

}