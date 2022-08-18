package bosonit.pruebareactive.tablero.infraestructure.controller;

import bosonit.pruebareactive.tablero.domain.Ficha;
import bosonit.pruebareactive.tablero.domain.Tablero;
import bosonit.pruebareactive.tablero.infraestructure.repository.TableroRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
public class TableroController {
    byte[] columnas = new byte[]{1, 2, 3, 4, 5, 6, 7};
    @Autowired
    private TableroRepository repository;

    @GetMapping("/partida/{id}")
    public Mono<Rendering> partida(@PathVariable int id) {
        return Mono
                .just(Rendering
                        .view("partida")
                        .modelAttribute("columnas", columnas) // hardcodeado lo siento :(
                        .modelAttribute("tablero", repository.findById(id))
                        .build());
    }

    @GetMapping("/tableros")
    public Mono<Rendering> getAll() {
        return Mono
                .just(Rendering
                        .view("index")
                        .modelAttribute("tableros", repository.findAll())
                        .build());
    }

    @GetMapping("/tablero")
    public Mono<Rendering> addForm() {
        return Mono
                .just(Rendering
                        .view("add-tablero")
                        .modelAttribute("tablero", new Tablero())
                        .build());
    }

    @PostMapping(path = "/tablero", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public Mono<Rendering> add(Tablero tablero) {
        tablero.setMatrix(new int[tablero.getNcolumnas()][tablero.getNfilas()]);
        return Mono
                .just(Rendering
                        .view("redirect:/tableros")
                        .modelAttribute("tablero", repository.save(tablero))
                        .build());
    }

    @GetMapping("/edit/{id}")
    public Mono<Rendering> editForm(@PathVariable Integer id) {
        return Mono
                .just(Rendering
                        .view("edit-tablero")
                        .modelAttribute("tablero", repository.findById(id))
                        .build());
    }

    @PostMapping(path = "/update/{id}")
    public Mono<Rendering> update(Tablero tablero) {
        tablero.setMatrix(new int[tablero.getNcolumnas()][tablero.getNfilas()]);
        return Mono
                .just(Rendering
                        .view("redirect:/tableros")
                        .modelAttribute("tableros", repository.save(tablero))
                        .build());
    }

    @PostMapping(path = "/mov/{id}")
    public Mono<Rendering> movimiento(@PathVariable int id, @Valid Tablero tablero) {

        int aux = tablero.getNcolumnas();
        System.out.println(tablero);
        for (int i = aux; i > 0; i--) {
            System.out.println(tablero.getMatrix()[id][i]);
            if (tablero.getMatrix()[id][i] == 0) {
                tablero.getMatrix()[id][i] = 1;
            }
        }
        tablero.setMatrix(new int[tablero.getNcolumnas()][tablero.getNfilas()]);
        return Mono
                .just(Rendering
                        .view("redirect:/partida/" + tablero.getId())
                        .modelAttribute("tableros", repository.save(tablero))
                        .build());
    }

//    @GetMapping("/delete/{id}")
//    public ResponseEntity<Mono<Tablero>> delete(@PathVariable Integer id) {
//        return Mono
//                .just(Rendering
//                        .view("redirect:/tableros")
//                        .modelAttribute("tableros", repository.deleteById(id))
//                        .build());
//
//        ResponseEntity.ok(service.movimiento());
//    }
}
