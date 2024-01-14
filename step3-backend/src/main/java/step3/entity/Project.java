package step3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "project")
@Entity(name = "Project")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id")
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "project")
    private List<Hazard> hazards;

    @OneToMany(mappedBy = "project")
    private List<Controller> controllers;

    @OneToOne(mappedBy = "project")
    private ContextTable contextTable;

    @OneToMany(mappedBy = "project")
    private List<UnsafeControlAction> unsafeControlActions;

    // Precisa da lista de Safety Constraints?

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
