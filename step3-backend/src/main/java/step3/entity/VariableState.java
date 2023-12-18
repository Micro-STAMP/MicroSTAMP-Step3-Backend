package step3.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "variable_state")
@Entity(name = "VariableState")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id")
public class VariableState {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "variable_id")
    private Variable variable;

    @ManyToOne
    @JoinColumn(name = "value_id")
    private Value value;

    public VariableState(Variable variable, Value value) {
        this.variable = variable;
        this.value = value;
    }
}
