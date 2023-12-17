package step3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToMany(mappedBy = "context", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContextCombination> combinations = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "context_table_id")
    private ContextTable contextTable;

    public Context(Context other) {
        this.id = other.id;
        this.combinations = new ArrayList<>(other.combinations);
        this.contextTable = other.contextTable;
    }

    public void addCombination(Variable variable, Value value) {
        combinations.add(new ContextCombination(this, variable, value));
    }
}
