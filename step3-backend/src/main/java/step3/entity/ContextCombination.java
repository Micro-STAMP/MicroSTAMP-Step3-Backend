package step3.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "context_combination")
@Entity(name = "ContextCombination")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id")
public class ContextCombination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "context_id")
    private Context context;

    @ManyToOne
    @JoinColumn(name = "variable_id")
    private Variable variable;

    @ManyToOne
    @JoinColumn(name = "value_id")
    private Value value;

    public ContextCombination(Context context, Variable variable, Value value) {
        this.context = context;
        this.variable = variable;
        this.value = value;
    }
}
