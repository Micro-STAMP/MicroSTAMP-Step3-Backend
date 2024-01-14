package step3.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "hazard")
@Entity(name = "Hazard")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id")
public class Hazard {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne @JoinColumn(name = "project_id")
    private Project project;

    public Hazard(String name, Project project) {
        this.name = name;
        this.project = project;
    }
}
