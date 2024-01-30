package step3.entity;

import lombok.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "rule")
@Entity(name = "Rule")
@Getter @Setter @NoArgsConstructor
public class Rule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL) @JoinColumn(name = "context_table_id")
    private ContextTable contextTable;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "rule_variable_state",
        joinColumns = @JoinColumn(name = "rule_id"),
        inverseJoinColumns = @JoinColumn(name = "variable_state_id")
    )
    private List<VariableState> variableStates = new ArrayList<>();

    // Constructors -----------------------------------

    public Rule(String name, ContextTable contextTable, List<VariableState> variableStates) {
        this.name = name;
        this.contextTable = contextTable;
        this.variableStates = variableStates;
    }
}
