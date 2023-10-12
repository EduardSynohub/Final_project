package pl.coderslab.domain.breakdown;

import java.util.List;
import java.util.Optional;

public interface BreakdownService {
    List<Breakdown> getAll();
    Optional<Breakdown> get(Long id);
    void add(Breakdown breakdown);
    void delete(Long id);
}
