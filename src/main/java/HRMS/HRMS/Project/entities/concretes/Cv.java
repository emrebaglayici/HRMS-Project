package HRMS.HRMS.Project.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cv")
public class Cv {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "github_link")
    private String github_link;

    @Column(name = "linkedin_link")
    private String linkedin_link;

    @Column(name = "cover_letter")
    private String cover_letter;

    @Column(name = "image")
    private String image;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(mappedBy = "cv")
    private List<Experience> experiences;

    @OneToMany(mappedBy = "cv")
    private List<ForeignLanguage> foreignLanguages;

    @OneToMany(mappedBy = "cv")
    private List<School> schools;

    @OneToMany(mappedBy = "cv")
    private List<Skill> skills;
}
