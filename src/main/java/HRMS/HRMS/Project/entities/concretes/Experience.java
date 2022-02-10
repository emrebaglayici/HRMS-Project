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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "experience")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "experience_id")
    private int id;

    @Column(name = "job_name")
    private String job_name;

    @Column(name = "job_position")
    private String job_position;


    @Column(name = "job_start_date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date job_startDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "job_end_date")
    private Date job_endDate;


    @NotNull
    @NotBlank
    @Column(name = "working_status")
    private boolean working_status;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cv_id")
    private Cv cv;
}
