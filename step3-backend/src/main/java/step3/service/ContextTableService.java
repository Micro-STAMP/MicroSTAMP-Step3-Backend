package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import step3.dto.context_table.*;
import step3.entity.*;
import step3.repository.*;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ContextTableService {
    private final ContextTableRepository contextTableRepository;
    private final ControllerRepository controllerRepository;

    // Create -----------------------------------------

    public ContextTableReadDto createContextTable(ContextTableCreateDto contextTableCreateDto) {
        Controller controller = controllerRepository.getReferenceById(contextTableCreateDto.controller_id());
        List<Variable> variables = controller.getVariables();
        ContextTable contextTable = generateContextTable(variables);
        contextTable.setController(controller);
        ContextTable createContextTable = contextTableRepository.save(contextTable);
        return new ContextTableReadDto(createContextTable);
    }

    // Read -------------------------------------------

    public ContextTableReadDto readContextTableById(Long id) {
        ContextTable contextTable = contextTableRepository.getReferenceById(id);
        return new ContextTableReadDto(contextTable);
    }
    public List<ContextTableReadDto> readAllContextTables() {
        List<ContextTable> contextTables = contextTableRepository.findAll();
        return contextTables.stream().map(ContextTableReadDto::new).toList();
    }
    public ContextTableReadDto readContextTableByController(Long controller_id) {
        List<ContextTable> contextTables = contextTableRepository.findAll();
        ContextTable contextTable = null;
        for (ContextTable ct : contextTables) {
            if (ct.getController().getId().equals(controller_id)) {
                contextTable = ct;
            }
        }

        // controllerRepository.getReferenceById(controller_id);
        if (contextTable != null) {
            return new ContextTableReadDto(contextTable);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Controller not found with id: " + controller_id);
        }
    }

    // Update -----------------------------------------


    // Delete -----------------------------------------
    @Transactional
    public void deleteContextTable(Long id) {
        var contextTable = contextTableRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Not found ct"));
        contextTable.getContexts().clear();
        contextTableRepository.save(contextTable);

        var controller = controllerRepository.getReferenceById(contextTable.getController().getId());
        controller.setContextTable(null);
        controllerRepository.save(controller);

//        contextTableRepository.deleteById(id);
    }

    // Methods ----------------------------------------

    public ContextTable generateContextTable(List<Variable> variables) {
        ContextTable contextTable = new ContextTable();
        generateAllContexts(variables, 0, new ArrayList<>(), contextTable);
        return contextTable;
    }
    private void generateAllContexts(List<Variable> variables, int index, List<Value> currentValues, ContextTable contextTable) {
        if (index == variables.size()) {
            contextTable.addContext(new Context(currentValues));
            return;
        }
        Variable currentVariable = variables.get(index);
        for (Value value : currentVariable.getValues()) {
            List<Value> updatedValues = new ArrayList<>(currentValues);
            updatedValues.add(value);
            generateAllContexts(variables, index + 1, updatedValues, contextTable);
        }
    }

    // ------------------------------------------------
}
