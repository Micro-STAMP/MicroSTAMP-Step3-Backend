package step3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import step3.entity.ContextTable;

import java.util.List;

public interface ContextTableRepository extends JpaRepository<ContextTable, Long> {
    List<ContextTable> findByControllerId(Long controllerId);
}
