package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.dto.project.ProjectCreateDto;
import step3.dto.project.ProjectReadAllDto;
import step3.dto.project.ProjectReadDto;
import step3.entity.Project;
import step3.repository.ProjectRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;

    // Create -----------------------------------------

    public ProjectCreateDto createProject(ProjectCreateDto projectCreateDto) {
        Project project = new Project(projectCreateDto.name(), projectCreateDto.description());

        Project createdProject = projectRepository.save(project);

        return projectCreateDto;
    }

    // Read -------------------------------------------

    public List<ProjectReadAllDto> readAllProjects() {
        return projectRepository.findAll().stream().map(ProjectReadAllDto::new).toList();
    }

    public ProjectReadDto readProjectById(Long id) {
        Project project = projectRepository.getReferenceById(id);
        return new ProjectReadDto(project);
    }

    // Update -----------------------------------------

    // Delete -----------------------------------------

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    // Methods ----------------------------------------

    // ------------------------------------------------
}
