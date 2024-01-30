package step3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import step3.entity.Rule;

public interface RuleRepository extends JpaRepository<Rule, Long> {
}
