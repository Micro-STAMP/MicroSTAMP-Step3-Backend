package step3.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.ArrayList;

@Getter @Setter
public class Context {
    List<Variable> variables;

    public Context() {
        variables = new ArrayList<>();
    }
}
