package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity createHazard(@RequestBody HazardCreateDto hazardCreateDto) {
        hazardService.createHazard(hazardCreateDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(hazardCreateDto);
    }

    @GetMapping
    public ResponseEntity<List<Hazard>> readAllHazards() {
        var hazardList = hazardService.readAllHazards();

        return ResponseEntity.ok(hazardList);
    }

    @PutMapping @Transactional
    public ResponseEntity updateHazard(@RequestBody Hazard hazard) {
        hazardService.updateHazard(hazard);

        return ResponseEntity.ok(hazard);
    }

    @DeleteMapping("/{id}") @Transactional
    public ResponseEntity deleteHazard(@PathVariable Long id) {
        hazardService.deleteHazard(id);

        return ResponseEntity.noContent().build();
    }
}
