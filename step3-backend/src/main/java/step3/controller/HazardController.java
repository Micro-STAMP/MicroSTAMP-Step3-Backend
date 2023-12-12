package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.dto.hazard.HazardCreateDto;
import step3.entity.Hazard;
import step3.service.HazardService;

import java.util.List;

@RestController
@RequestMapping("/hazard")
public class HazardController {
    private final HazardService hazardService;

    @Autowired
    public HazardController(HazardService hazardService) {
        this.hazardService = hazardService;
    }

    @PostMapping @Transactional
    public void createHazard(@RequestBody HazardCreateDto hazardCreateDto) {
        hazardService.createHazard(hazardCreateDto);
    }

    @GetMapping
    public List<Hazard> readAllHazards() {
        return hazardService.readAllHazards();
    }

    @PutMapping @Transactional
    public void updateHazard(@RequestBody Hazard hazard) {
        hazardService.updateHazard(hazard);
    }

    @DeleteMapping("/{id}") @Transactional
    public void deleteHazard(@PathVariable Long id) {
        hazardService.deleteHazard(id);
    }
}
