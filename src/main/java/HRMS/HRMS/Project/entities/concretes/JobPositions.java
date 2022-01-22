package HRMS.HRMS.Project.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "JobPositions")
public class JobPositions {
    @Id
    @GeneratedValue
    @Column(name = "UserId")
    private int UserId;

    @Column(name = "PositionName")
    private String PositionName;

    public JobPositions(){}

    public JobPositions(int userId, String positionName) {
        this.UserId = userId;
        this.PositionName = positionName;
    }
}
