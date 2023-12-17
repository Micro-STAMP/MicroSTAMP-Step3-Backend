package step3.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "context_table")
@Entity(name = "ContextTable")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id")
public class ContextTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "contextTable", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Context> contexts = new ArrayList<>();

    public ContextTable(List<Context> contexts) {
        this.contexts = contexts;
    }

    public void addContext(Context context) {
        this.contexts.add(context);
        context.setContextTable(this);
    }
}
