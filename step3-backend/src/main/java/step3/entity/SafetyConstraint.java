package step3.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "safety_contraint")
@Entity(name = "SafetyConstraint")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id")
public class SafetyConstraint {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}