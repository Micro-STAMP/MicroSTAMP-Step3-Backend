package step3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import step3.dto.context.ContextCombinationDto;

@Table(name = "context_combination")
@Entity(name = "ContextCombination")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id")
public class ContextCombination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
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
