package step3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import step3.entity.ContextTable;

public interface ContextTableRepository extends JpaRepository<ContextTable, Long> {
}
