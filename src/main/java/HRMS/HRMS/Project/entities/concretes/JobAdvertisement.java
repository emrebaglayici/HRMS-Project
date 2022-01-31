package HRMS.HRMS.Project.entities.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_ads")
public class JobAdvertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "job_ads_id")
    private int id;

    @NotNull
    @NotBlank
    @Column(name = "description")
    private String description;

    @Column(name = "max_salary")
    private double max_salary;

    @Column(name = "min_salary")
    private double min_salary;

    @NotNull
    @Column(name = "open_positions")
    private int open_positions;

    @NotNull
    @Column(name = "latest_apply_time")
    private String latest_apply_time;

    @NotNull
    @Column(name = "creation_time")
    private String creation_time;

    @NotNull
    @Column(name = "is_active")
    private boolean is_activated;

    @Column(name = "city_id")
    private int city_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private JobPositions jobPositions;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employer_id")
    private Employer employer;
}
