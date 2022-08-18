package bosonit.pruebareactive.tablero.domain;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ficha {
    private int fila;
    private int columna;
    private int color;
}
