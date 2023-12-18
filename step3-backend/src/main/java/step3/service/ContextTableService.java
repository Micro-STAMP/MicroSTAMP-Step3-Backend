package step3.service;

import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Var;
import org.springframework.stereotype.Service;
import step3.dto.context_table.ContextTableCreateDto;
import step3.dto.context_table.ContextTableReadDto;
import step3.entity.*;
import step3.repository.ContextTableRepository;
import step3.repository.VariableRepository;

import java.util.ArrayList;
import java.util.List;

@Service @AllArgsConstructor
public class ContextTableService {
    private final ContextTableRepository contextTableRepository;
    private final VariableRepository variableRepository;
    public void createContextTable(ContextTableCreateDto contextTableCreateDto) {
        List<Variable> variables = variableRepository.findAllById(contextTableCreateDto.variable_ids());
        ContextTable contextTable = generateContextTable(variables);
        contextTableRepository.save(contextTable);
    }

    public ContextTableReadDto readContextTableById(Long id) {
        ContextTable contextTable = contextTableRepository.getReferenceById(id);
        return new ContextTableReadDto(contextTable);
    }

    public List<ContextTableReadDto> readAllContextTables() {
        List<ContextTable> contextTables = contextTableRepository.findAll();
        return contextTables.stream().map(ContextTableReadDto::new).toList();
    }

    public void updateContextTable() {
        // Precisa?
    }

    public void deleteContextTable(Long id) {
        contextTableRepository.deleteById(id);
    }


    // Funções auxiliares para gerar as combinações da tabela.
    private ContextTable generateContextTable(List<Variable> variables) {
        ContextTable contextTable = new ContextTable();
        List<VariableState> allVariableStates = generateAllVariableStates(variables);
        generateContexts(variables, contextTable, new ArrayList<>(), 0, allVariableStates);
        return contextTable;
    }
    private void generateContexts(List<Variable> variables, ContextTable contextTable, List<Value> currentState, int variableIndex, List<VariableState> allVariableStates) {
        if (variableIndex == variables.size()) {
            Context context = new Context();
            for (int i = 0; i < variables.size(); i++) {
                VariableState variableState = findVariableState(variables.get(i), currentState.get(i), allVariableStates);
                context.addVariableState(variableState);
            }
            contextTable.addContext(context);
            return;
        }
        Variable currentVariable = variables.get(variableIndex);
        List<Value> currentVariableValues = currentVariable.getValues();

        for (Value value : currentVariableValues) {
            List<Value> updatedState = new ArrayList<>(currentState);
            updatedState.add(value);
            generateContexts(variables, contextTable, updatedState, variableIndex + 1, allVariableStates);
        }
    }
    private List<VariableState> generateAllVariableStates(List<Variable> variables) {
        List<VariableState> variableStates = new ArrayList<>();
        for(Variable variable : variables) {
            for(Value value : variable.getValues()) {
                variableStates.add(new VariableState(variable, value));
            }
        }
        return variableStates;
    }
    private VariableState findVariableState(Variable variable, Value value, List<VariableState> variableStates) {
        for (VariableState variableState : variableStates) {
            if (variableState.getVariable().equals(variable) && variableState.getValue().equals(value)) {
                return variableState;
            }
        }
        return new VariableState(variable, value);
    }

}
