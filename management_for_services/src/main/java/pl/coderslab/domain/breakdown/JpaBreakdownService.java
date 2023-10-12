package pl.coderslab.domain.breakdown;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JpaBreakdownService implements BreakdownService{

    private final BreakdownRepository breakdownRepository;

    public JpaBreakdownService(BreakdownRepository breakdownRepository) {
        this.breakdownRepository = breakdownRepository;
    }

    @Override
    public List<Breakdown> getAll() {
        return breakdownRepository.findAll();
    }

    @Override
    public Optional<Breakdown> get(Long id) {
        return breakdownRepository.findById(id);
    }

    @Override
    public void create(Breakdown breakdown) {
        breakdownRepository.save(breakdown);
    }

    @Override
    public void delete(Long id) {
        breakdownRepository.deleteById(id);
    }
}
