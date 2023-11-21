package step3.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SafetyConstraint {
    private Long id;
    private String name;

    public SafetyConstraint(String name) {
        this.name = name;
    }
}
