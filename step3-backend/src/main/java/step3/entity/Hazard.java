package step3.entity;

import lombok.*;
import jakarta.persistence.*;
//import org.apache.commons.lang3.builder.EqualsBuilder;

@Table(name = "hazard")
@Entity(name = "Hazard")
@Getter @Setter @NoArgsConstructor
public class Hazard {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne @JoinColumn(name = "project_id")
    private Project project;

    // Constructors -----------------------------------

    public Hazard(String name, Project project) {
        this.name = name;
        this.project = project;
    }

    // Methods ----------------------------------------

//    @Override
//    public boolean equals(Object obj) {
//        return EqualsBuilder.reflectionEquals(obj, this);
//    }

    // ------------------------------------------------
}
