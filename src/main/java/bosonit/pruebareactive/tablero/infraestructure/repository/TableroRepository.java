package bosonit.pruebareactive.tablero.infraestructure.repository;

import bosonit.pruebareactive.tablero.domain.Tablero;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TableroRepository extends ReactiveCrudRepository<Tablero, Integer> {
}
