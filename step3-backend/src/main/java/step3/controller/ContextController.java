package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.entity.Context;
import step3.repository.ContextRepository;

import java.util.List;

@RestController
@RequestMapping("/context")
public class ContextController {
    @Autowired
    private ContextRepository contextRepository;

    @PostMapping @Transactional
    public void createContext(@RequestBody Context context) {
        contextRepository.save(context);
    }

    @GetMapping
    public List<Context> readAllContext() {
        return contextRepository.findAll();
    }

    @PutMapping @Transactional
    public void updateContext(@RequestBody Context context) {
        Context updatedContext = contextRepository.getReferenceById(context.getId());
        updatedContext.setVariables(context.getVariables());
        updatedContext.setValues(context.getValues());
    }

    @DeleteMapping("/{id}") @Transactional
    public void deleteContext(@PathVariable Long id) {
        contextRepository.deleteById(id);
    }

}
