package step3.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Variable {
    private Long id;
    List<String> values;

    public Variable() {
        this.values = new ArrayList<>();
    }
}
