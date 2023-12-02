package step3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import step3.entity.Controller;

public interface ControllerRepository extends JpaRepository<Controller, Long> {
}
