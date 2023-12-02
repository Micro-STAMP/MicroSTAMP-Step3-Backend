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
}
