package step3.entity;

import lombok.*;
import jakarta.persistence.*;
import step3.dto.context.ContextCreateDto;

import java.util.ArrayList;
import java.util.List;

@Table(name = "context")
@Entity(name = "Context")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id")
public class Context {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "context")
    private List<ContextCombination> contextCombinations = new ArrayList<>();

    public void addCombination(Variable variable, Value value) {
        contextCombinations.add(new ContextCombination(this, variable, value));
    }
}
