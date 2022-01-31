package HRMS.HRMS.Project.entities.concretes;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "school")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "school_id")
    private int id;

    @NotNull
    @NotBlank
    @Column(name = "school_name")
    private String school_name;

    @NotNull
    @NotBlank
    @Column(name = "education_department")
    private String education_department;

    @NotNull
    @NotBlank
    @Column(name = "graduation_status")
    private boolean graduation_status;

    @NotNull
    @NotBlank
    @Column(name = "graduation_year")
    private String graduation_year;

    @Column(name = "school_start_date")
    private String school_start_date;

    @Column(name = "school_end_date")
    private String school_end_date;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "cv_id")
    private Cv cv;
}
