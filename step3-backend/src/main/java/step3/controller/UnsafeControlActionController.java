package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.entity.UnsafeControlAction;
import step3.repository.UnsafeControlActionRepository;

import java.util.List;

@RestController
@RequestMapping("/unsafe-control-action")
public class UnsafeControlActionController {
    @Autowired
    private UnsafeControlActionRepository ucaRepository;

    @PostMapping @Transactional
    public void createUnsafeControlAction(@RequestBody UnsafeControlAction uca) {
        ucaRepository.save(uca);
    }

    @GetMapping
    public List<UnsafeControlAction> readAllUnsafeControlAction() {
        return ucaRepository.findAll();
    }

    @PutMapping @Transactional
    public void updateUnsafeControlAction(@RequestBody UnsafeControlAction uca) {
        UnsafeControlAction updatedUca = ucaRepository.getReferenceById(uca.getId());
        updatedUca.setName(uca.getName());
        updatedUca.setConstraint(uca.getConstraint());
        updatedUca.setContext(uca.getContext());
        updatedUca.setHazard(uca.getHazard());
    }

    @DeleteMapping("/{id}") @Transactional
    public void deleteUnsafeControlAction(@PathVariable Long id) {
        ucaRepository.deleteById(id);
    }
}
