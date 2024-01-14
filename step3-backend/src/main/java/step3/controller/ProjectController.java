package step3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import step3.dto.project.ProjectCreateDto;
import step3.dto.project.ProjectReadAllDto;
import step3.dto.project.ProjectReadDto;
import step3.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping @Transactional
    public ResponseEntity<ProjectCreateDto> createProject(@RequestBody ProjectCreateDto projectCreateDto) {
        projectService.createProject(projectCreateDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(projectCreateDto);
    }

    @GetMapping
    public ResponseEntity<List<ProjectReadAllDto>> readAllProjects() {
        return ResponseEntity.ok(projectService.readAllProjects());
    }

    @GetMapping("/{id}")
    public  ResponseEntity<ProjectReadDto> readProjectById(@PathVariable Long id) {
        return ResponseEntity.ok(projectService.readProjectById(id));
    }

    @DeleteMapping("/{id}") @Transactional
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
