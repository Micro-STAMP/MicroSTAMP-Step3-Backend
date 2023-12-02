package step3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import step3.entity.ControlAction;

public interface ControlActionRepository extends JpaRepository<ControlAction, Long> {
}
