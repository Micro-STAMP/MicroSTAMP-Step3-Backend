package step3.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class Variable {
    private Long id;
    private List<Value> values;
}
