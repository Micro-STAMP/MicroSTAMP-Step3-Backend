package step3.entity;

import lombok.*;
import jakarta.persistence.*;

@Table(name = "safety_constraint")
@Entity(name = "SafetyConstraint")
@Getter @Setter @NoArgsConstructor
public class SafetyConstraint {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Constructors -----------------------------------

    public SafetyConstraint(String name) {
        this.name = name;
    }
}
