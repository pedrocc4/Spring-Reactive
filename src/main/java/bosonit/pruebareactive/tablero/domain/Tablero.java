package bosonit.pruebareactive.tablero.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
public class Tablero {
    @Id
    private Integer id;

    @NotNull
    private String nombre;
}
