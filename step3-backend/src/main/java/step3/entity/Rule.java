package step3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "rule")
@Entity(name = "Rule")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id")
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "context_table_id")
    private ContextTable contextTable;

    @ManyToMany
    @JoinTable(
            name = "rule_variable_state",
            joinColumns = @JoinColumn(name = "rule_id"),
            inverseJoinColumns = @JoinColumn(name = "variable_state_id")
    )
    private List<VariableState> ruleVariableStates = new ArrayList<>();

    public Rule(String name, ContextTable contextTable, List<VariableState> ruleVariableStates) {
        this.name = name;
        this.contextTable = contextTable;
        this.ruleVariableStates = ruleVariableStates;
    }
}
