package bosonit.pruebareactive.tablero.infraestructure.controller;

import bosonit.pruebareactive.tablero.domain.Tablero;
import bosonit.pruebareactive.tablero.infraestructure.repository.TableroRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.reactive.result.view.Rendering;
import reactor.core.publisher.Mono;

@Controller
@Slf4j
public class TableroController {

    @Autowired
    private TableroRepository repository;

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
        return Mono
                .just(Rendering
                        .view("redirect:/tableros")
                        .modelAttribute("tableros", repository.save(tablero))
                        .build());
    }

    @GetMapping("/delete/{id}")
    public Mono<Rendering> delete(@PathVariable Integer id) {

        return Mono
                .just(Rendering
                        .view("redirect:/tableros")
                        .modelAttribute("tableros", repository.deleteById(id))
                        .build());
    }
}
