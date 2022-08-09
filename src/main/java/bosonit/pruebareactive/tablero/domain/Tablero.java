package bosonit.pruebareactive.tablero.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.validation.constraints.NotNull;

@Data
@RequiredArgsConstructor
public class Tablero {
    private Integer id;

    @NotNull
    private String nombre;
}
