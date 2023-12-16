package step3.dto.context;

import step3.entity.Context;

import java.util.List;

public record ContextReadDto(Long id, List<ContextCombinationDto> combinations) {
    public ContextReadDto(Context context) {
        this(
            context.getId(),
            context.getCombinations().stream().map(
                combination -> new ContextCombinationDto(
                    combination.getVariable().getId(),
                    combination.getValue().getId()
                )
            ).toList()
        );
    }
}
