package HRMS.HRMS.Project.entities.concretes;

import HRMS.HRMS.Project.entities.abstracts.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "employer",schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","employer"})
@PrimaryKeyJoinColumn(name = "employer_id",referencedColumnName = "id")
public class Employer extends User {

    @NotNull
    @NotBlank
    @Column(name = "company_name")
    private String company_name;

    @NotNull
    @NotBlank
    @Column(name = "website")
    private String website;

    @NotNull
    @NotBlank
    @Column(name="phone")
    private String phone;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<JobAdvertisement> jobAdvertisements;
}