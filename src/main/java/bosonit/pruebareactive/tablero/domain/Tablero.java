package bosonit.pruebareactive.tablero.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
public class Tablero {
    private Integer id;

    @NotNull
    private String nombre;
}
