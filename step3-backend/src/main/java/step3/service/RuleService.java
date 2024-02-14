package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.dto.rule.*;
import step3.entity.*;
import step3.repository.*;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class RuleService {
    private final RuleRepository ruleRepository;
    private final ControlActionRepository controlActionRepository;
    private final ValueRepository valueRepository;
    private final HazardRepository hazardRepository;

    // Create -----------------------------------------

    public RuleReadDto createRule(RuleCreateDto ruleCreateDto){
        List<Value> values = getRuleValues(ruleCreateDto.values_ids());
        ControlAction controlAction = controlActionRepository.getReferenceById(ruleCreateDto.control_action_id());
        Hazard hazard = hazardRepository.getReferenceById(ruleCreateDto.hazard_id());

        Rule rule = new Rule(ruleCreateDto.name(), controlAction, values, hazard, ruleCreateDto.types());
        Rule createdRule = ruleRepository.save(rule);
        return new RuleReadDto(createdRule);
    }

    // Read -------------------------------------------

    public RuleReadDto readRule(Long id) {
        Rule rule = ruleRepository.getReferenceById(id);
        return new RuleReadDto(rule);
    }
    public List<RuleReadListDto> readAllRules() {
        return ruleRepository.findAll().stream().map(RuleReadListDto::new).toList();
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
