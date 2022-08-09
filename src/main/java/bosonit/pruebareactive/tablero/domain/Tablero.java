package bosonit.pruebareactive.tablero.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;


@Data
@RequiredArgsConstructor
public class Tablero {
    @Id
    private int id;
    @Column
    private String nombre;
}
