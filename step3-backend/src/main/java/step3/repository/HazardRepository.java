package step3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import step3.entity.Hazard;

public interface HazardRepository extends JpaRepository<Hazard, Long> {
}
