package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.entity.Hazard;
import step3.repository.HazardRepository;

import java.util.List;

@RestController
@RequestMapping("/hazard")
public class HazardController {
    @Autowired
    private HazardRepository hazardRepository;

    @PostMapping @Transactional
    public void createHazard(@RequestBody Hazard hazard) {
        hazardRepository.save(hazard);
    }

    @GetMapping
    public List<Hazard> readAllHazard() {
        return hazardRepository.findAll();
    }

    @PutMapping @Transactional
    public void updateHazard(@RequestBody Hazard hazard) {
        Hazard updatedHazard = hazardRepository.getReferenceById(hazard.getId());
        updatedHazard.setName(hazard.getName());
    }
}
