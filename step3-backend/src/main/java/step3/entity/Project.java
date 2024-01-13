package step3.entity;

import lombok.*;

import java.util.List;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "id")
public class Project {
    private Long id;
    private String name;
    private String description;
    private List<Hazard> hazards;
    private List<Controller> controllers;
    // Precisa da lista de Safety Constraints?
    private ContextTable contextTable;
    private List<UnsafeControlAction> unsafeControlActions;
}
