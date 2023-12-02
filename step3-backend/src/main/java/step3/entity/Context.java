package step3.entity;

import lombok.*;
import jakarta.persistence.*;
import java.util.List;

@Table(name = "context")
@Entity(name = "Context")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id")
public class Context {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // private List<Variable> variables;
    // private List<Value> values;
}
