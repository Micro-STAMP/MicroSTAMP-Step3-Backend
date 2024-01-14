package step3.dto.project;

import step3.entity.Project;

public record ProjectReadAllDto(
        Long id,
        String name,
        String description
) {
    public ProjectReadAllDto(Project project) {
        this(project.getId(), project.getName(), project.getDescription());
    }
}
