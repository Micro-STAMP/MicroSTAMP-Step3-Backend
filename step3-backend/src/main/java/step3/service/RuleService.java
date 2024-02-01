package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.dto.rule.RuleCreateDto;
import step3.dto.rule.RuleReadDto;
import step3.entity.ContextTable;
import step3.entity.Rule;
import step3.entity.Value;
import step3.repository.ContextTableRepository;
import step3.repository.RuleRepository;
import step3.repository.ValueRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RuleService {
    private final RuleRepository ruleRepository;
    private final ContextTableRepository contextTableRepository;
    private final ValueRepository valueRepository;

    // Create -----------------------------------------

    public void createRule(RuleCreateDto ruleCreateDto){
        ContextTable contextTable = contextTableRepository.getReferenceById(ruleCreateDto.context_table_id());
        List<Value> values = getRuleValues(ruleCreateDto.values_ids());
        Rule rule = new Rule(ruleCreateDto.name(), contextTable, values);
        ruleRepository.save(rule);
    }

    // Read -------------------------------------------

    public List<RuleReadDto> readAllRules() {
        List<Rule> rules = ruleRepository.findAll();
        return rules.stream().map(RuleReadDto::new).toList();
    }

    // Update -----------------------------------------

    // Delete -----------------------------------------

    public void deleteRule(Long id) {
        ruleRepository.deleteById(id);
    }

    // Methods ----------------------------------------

    public List<Value> getRuleValues(List<Long> valuesIds) {
        List<Value> values = new ArrayList<>();
        for(Long value_id : valuesIds) {
            Value value = valueRepository.getReferenceById(value_id);
            values.add(value);
        }
        return values;
    }

    // ------------------------------------------------
}
