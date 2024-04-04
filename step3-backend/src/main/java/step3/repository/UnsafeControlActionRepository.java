package step3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import step3.entity.UnsafeControlAction;

import java.util.List;

public interface UnsafeControlActionRepository extends JpaRepository<UnsafeControlAction, Long> {
    List<UnsafeControlAction> findByControlActionId(Long id);
}
