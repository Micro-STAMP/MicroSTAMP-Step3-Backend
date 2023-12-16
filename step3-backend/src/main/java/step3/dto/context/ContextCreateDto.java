package step3.dto.context;

import java.util.List;

public record ContextCreateDto(
        List<ContextCombinationCreateDto> contextCombinations
) {}
