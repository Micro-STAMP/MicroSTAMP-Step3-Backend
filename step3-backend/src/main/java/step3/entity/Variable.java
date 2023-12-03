package step3.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Table(name = "variable")
@Entity(name = "Variable")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id")
public class Variable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "value")
    private List<Value> values;
}