package step3.dto.context;

import java.util.List;

public record ContextUpdateDto(
        Long id,
        List<ContextCombinationDto> combinations
) {}
