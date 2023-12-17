package step3.dto.context_table;

import step3.entity.Context;

import java.util.List;

public record ContextReadDto(
        List<ContextCombinationReadDto> combinations
) {
    public ContextReadDto(Context context) {
        this(context.getCombinations().stream().map(ContextCombinationReadDto::new).toList());
    }
}