package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity createRule(@RequestBody RuleCreateDto ruleCreateDto) {
        ruleService.createRule(ruleCreateDto);

        return ResponseEntity.created(null).body(ruleCreateDto);
    }

    @GetMapping
    public ResponseEntity<List<RuleReadDto>> readAllRules() {
        var responseRule = ruleService.readAllRules();

        return ResponseEntity.ok(responseRule);
    }

    @PutMapping @Transactional
    public void updateRule(){
        ruleService.updateRule();
    }

    @DeleteMapping("/{id}") @Transactional
    public ResponseEntity deleteRule(@PathVariable Long id) {
        ruleService.deleteRule(id);

        return ResponseEntity.noContent().build();
    }

}
