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

    @ManyToMany
    @JoinTable(
        name = "context_variable",
        joinColumns = @JoinColumn(name = "context_id"),
        inverseJoinColumns = @JoinColumn(name = "variable_id")
    )
    private List<Variable> variables;

    @ManyToMany
    @JoinTable(
        name = "context_value",
        joinColumns = @JoinColumn(name = "context_id"),
        inverseJoinColumns = @JoinColumn(name = "value_id")
    )
    private List<Value> values;
}
