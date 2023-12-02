package step3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import step3.entity.Variable;

public interface VariableRepository extends JpaRepository<Variable, Long> {
}
