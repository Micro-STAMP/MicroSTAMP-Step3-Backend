package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.dto.rule.RuleCreateDto;
import step3.dto.rule.RuleReadDto;
import step3.dto.variable_state.VariableStateCreateDto;
import step3.entity.ContextTable;
import step3.entity.Rule;
import step3.entity.VariableState;
import step3.repository.ContextTableRepository;
import step3.repository.RuleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service @AllArgsConstructor
public class RuleService {
    private final RuleRepository ruleRepository;
    private final ContextTableRepository contextTableRepository;

    public void createRule(RuleCreateDto ruleCreateDto){
        ContextTable contextTable = contextTableRepository.getReferenceById(ruleCreateDto.context_table_id());
        List<VariableState> variableStates = getRuleVariableStates(contextTable, ruleCreateDto.variable_states());
        Rule rule = new Rule(ruleCreateDto.name(), contextTable, variableStates);
        ruleRepository.save(rule);
    }

    public List<RuleReadDto> readAllRules() {
        List<Rule> rules = ruleRepository.findAll();
        return rules.stream().map(RuleReadDto::new).toList();
    }

    public void updateRule() {
        // Update Rule
    }

    public void deleteRule(Long id) {
        ruleRepository.deleteById(id);
    }


    // Funções auxiliares para a criação da regra
    public List<VariableState> getRuleVariableStates(ContextTable contextTable, List<VariableStateCreateDto> variableStateIds) {
        Set<VariableState> variableStatesSet = contextTable.getVariableStates();
        List<VariableState> variableStates = new ArrayList<>();
        for(VariableStateCreateDto stateDto : variableStateIds) {
            VariableState variableState = findVariableStateByIds(variableStatesSet,stateDto.variable_id(), stateDto.value_id());
            variableStates.add(variableState);
        }
        return variableStates;
    }
    public VariableState findVariableStateByIds(Set<VariableState> variableStates, Long variableId, Long valueId) {
        for (VariableState variableState : variableStates) {
            Long currentVariableId = variableState.getVariable().getId();
            Long currentValueId = variableState.getValue().getId();
            if (currentVariableId.equals(variableId) && currentValueId.equals(valueId)) {
                return variableState;
            }
        }
        return null;
    }

}
