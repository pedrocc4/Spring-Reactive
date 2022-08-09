package bosonit.pruebareactive.tablero.infraestructure.controller;

import bosonit.pruebareactive.tablero.domain.Tablero;
import bosonit.pruebareactive.tablero.infraestructure.repository.TableroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("tablero")
public class TableroController {

    @Autowired
    private TableroRepository repository;

    @GetMapping
    public Flux<Tablero> getAll() {
        return repository.findAll();
    }

    @PostMapping
    public Mono<Tablero> add(@RequestBody Tablero tablero){
        return repository.save(tablero);
    }
}
