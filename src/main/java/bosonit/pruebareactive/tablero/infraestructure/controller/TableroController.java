package bosonit.pruebareactive.tablero.infraestructure.controller;

import bosonit.pruebareactive.tablero.domain.Tablero;
import bosonit.pruebareactive.tablero.infraestructure.repository.TableroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("tablero")
public class TableroController {

    @Autowired
    private TableroRepository repository;

    @GetMapping("")
    public ResponseEntity<Flux<Tablero>> getAll() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Mono<Tablero>> getById(@PathVariable int id) {
        return new ResponseEntity<>(repository.findById(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Mono<Tablero>> add(@RequestBody Tablero tablero) {
        return new ResponseEntity<>(repository.save(tablero), HttpStatus.CREATED);
    }
}
