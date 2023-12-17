package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import step3.dto.context_table.ContextTableCreateDto;
import step3.dto.context_table.ContextTableReadDto;
import step3.entity.Context;
import step3.entity.ContextTable;
import step3.entity.Value;
import step3.entity.Variable;
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
        generateCombinations(variables, new Context(), contextTable, 0);
        return contextTable;
    }
    private void generateCombinations(List<Variable> variables, Context context, ContextTable contextTable, int variableIndex) {
        if (variableIndex == variables.size()) {
            contextTable.addContext(context);
            return;
        }
        Variable currentVariable = variables.get(variableIndex);
        List<Value> currentVariableValues = currentVariable.getValues();
        for (Value value : currentVariableValues) {
            context.addCombination(currentVariable, value);
            generateCombinations(variables, context, contextTable, variableIndex + 1);
        }
    }
}
