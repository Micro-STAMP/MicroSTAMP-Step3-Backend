package step3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import step3.entity.Context;

public interface ContextRepository extends JpaRepository<Context, Long> {
}
