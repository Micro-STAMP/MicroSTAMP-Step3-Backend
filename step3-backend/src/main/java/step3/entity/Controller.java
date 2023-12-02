package step3.entity;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class Controller {
    private Long id;
    private String name;
    private List<ControlAction> controlActions;
}
