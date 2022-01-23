package HRMS.HRMS.Project.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "job_positions")
@AllArgsConstructor
@NoArgsConstructor
public class JobPositions {
    @Id
    @GeneratedValue()
    @Column(name = "user_id")
    private int UserId;

    @Column(name = "position_name")
    private String PositionName;

}
