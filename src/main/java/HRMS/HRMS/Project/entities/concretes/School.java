package HRMS.HRMS.Project.entities.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "school")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
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
    @Column(name = "graduation_status")
    private boolean graduation_status;



    @JsonFormat(pattern = "yyyy")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "graduation_year")
    private Date graduation_year;


    @JsonFormat(pattern = "yyyy")
    @Column(name = "school_start_date")
    private Date school_start_date;

//    @Column(name = "school_end_date")
//    private String school_end_date;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cv_id")
    private Cv cv;
}
