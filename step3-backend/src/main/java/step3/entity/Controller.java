package step3.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Table(name = "controller")
@Entity(name = "Controller")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id")
public class Controller {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "controller")
    private List<ControlAction> controlActions;
}
