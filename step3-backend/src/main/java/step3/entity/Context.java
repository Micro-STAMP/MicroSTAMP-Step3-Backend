package step3.entity;

import lombok.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "context")
@Entity(name = "Context")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id")
public class Context {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "context_variable_state",
            joinColumns = @JoinColumn(name = "context_id"),
            inverseJoinColumns = @JoinColumn(name = "variable_state_id")
    )
    private List<VariableState> variableStates = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "context_table_id")
    private ContextTable contextTable;

    public Context(Context other) {
        this.id = other.id;
        this.variableStates = new ArrayList<>(other.variableStates);
        this.contextTable = other.contextTable;
    }

    public void addVariableState(Variable variable, Value value) {
        variableStates.add(new VariableState(variable, value));
    }
    public void addVariableState(VariableState variableState) {
        variableStates.add(variableState);
    }
}
