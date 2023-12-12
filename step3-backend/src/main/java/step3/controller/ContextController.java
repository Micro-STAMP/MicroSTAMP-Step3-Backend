package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.dto.context.ContextCreateDto;
import step3.entity.Context;
import step3.repository.ContextRepository;
import step3.service.ContextService;

import java.util.List;

@RestController
@RequestMapping("/context")
public class ContextController {
    private final ContextService contextService;
    @Autowired
    public ContextController(ContextService contextService) {
        this.contextService = contextService;
    }

    @PostMapping @Transactional
    public void createContext(@RequestBody ContextCreateDto contextCreateDto) {
        contextService.createContext(contextCreateDto);
    }

    @GetMapping
    public List<Context> readAllContexts() {
        return contextService.readAllContexts();
    }

    @PutMapping @Transactional
    public void updateContext(@RequestBody Context context) {
        contextService.updateContext(context);
    }

    @DeleteMapping("/{id}") @Transactional
    public void deleteContext(@PathVariable Long id) {
        contextService.deleteContext(id);
    }

}
