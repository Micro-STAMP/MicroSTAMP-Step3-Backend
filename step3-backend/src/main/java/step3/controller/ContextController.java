package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.dto.context.ContextReadDto;
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

    @GetMapping
    public List<ContextReadDto> readAllContexts() {
        return contextService.readAllContexts();
    }

}
