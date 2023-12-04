package step3.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "value")
@Entity(name = "Value")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id")
public class Value {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne @JoinColumn(name = "variable_id")
    private Variable variable;

    public Value(String name, Variable variable) {
        this.name = name;
        this.variable = variable;
    }
}
