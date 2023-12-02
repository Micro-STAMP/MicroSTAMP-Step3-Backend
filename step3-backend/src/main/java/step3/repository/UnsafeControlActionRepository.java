package step3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import step3.entity.UnsafeControlAction;

public interface UnsafeControlActionRepository extends JpaRepository<UnsafeControlAction, Long> {
}
