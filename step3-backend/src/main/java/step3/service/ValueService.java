package step3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import step3.entity.Value;
import step3.repository.ValueRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ValueService {
    private final ValueRepository valueRepository;

    public List<Value> findAll() {
        return valueRepository.findAll();
    }
    public Optional<Value> find(Long id) {
        return valueRepository.findById(id);
    }
    public Value save(Value value) {
        return valueRepository.save(value);
    }
    public void deleteById(Long id) {
        valueRepository.deleteById(id);
    }
}
