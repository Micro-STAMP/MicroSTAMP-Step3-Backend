package step3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "context_table")
@Entity(name = "ContextTable")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id")
public class ContextTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "contextTable", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Context> contexts = new ArrayList<>();

    @OneToOne @JoinColumn(name = "project_id")
    private Project project;
    
    public void addContext(Context context) {
        this.contexts.add(context);
        context.setContextTable(this);
    }

    public Set<VariableState> getVariableStates() {
        Set<VariableState> variableStates = new HashSet<>();
        for (Context context : contexts) {
            variableStates.addAll(context.getVariableStates());
        }
        return variableStates;
    }
}
