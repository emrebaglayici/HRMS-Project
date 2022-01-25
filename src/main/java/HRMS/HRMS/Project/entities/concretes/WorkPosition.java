package HRMS.HRMS.Project.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "work_position")
@AllArgsConstructor
@NoArgsConstructor
public class WorkPosition {
    @Id
    @GeneratedValue()
    @Column(name = "id")
    private int id;

    @Column(name = "position_name")
    private String positionName;

    @Column(name = "modified_user")
    private int modified_user;

}
