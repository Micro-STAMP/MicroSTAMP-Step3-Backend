package step3.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class Context {
    private Long id;
    private List<Variable> variables;
}
