package step3.entity;

import lombok.*;

// TODO Talvez seja uma classe
@Getter @Setter @NoArgsConstructor
public class ControlActionWithContext {
    private Long id;
    private Controller controller;
    private ControlAction controlAction;
    private Context context;
    private Hazard associatedHazard;

    // Constructors -----------------------------------

    // Methods ----------------------------------------

    // ------------------------------------------------
}
