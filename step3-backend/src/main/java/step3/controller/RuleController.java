package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.dto.rule.RuleCreateDto;
import step3.dto.rule.RuleReadDto;
import step3.service.RuleService;

import java.util.List;

@RestController
@RequestMapping("/rule")
public class RuleController {
    private final RuleService ruleService;

    @Autowired
    public RuleController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @PostMapping @Transactional
    public void createRule(@RequestBody RuleCreateDto ruleCreateDto) {
        ruleService.createRule(ruleCreateDto);
    }

    @GetMapping
    public List<RuleReadDto> readAllRules() {
        return ruleService.readAllRules();
    }

    @PutMapping @Transactional
    public void updateRule(){
        ruleService.updateRule();
    }

    @DeleteMapping("/{id}") @Transactional
    public void deleteRule(@PathVariable Long id) {
        ruleService.deleteRule(id);
    }

}
