package bosonit.pruebareactive.tablero.infraestructure.controller;

import bosonit.pruebareactive.tablero.domain.Tablero;
import bosonit.pruebareactive.tablero.infraestructure.repository.TableroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.thymeleaf.spring5.context.webflux.IReactiveDataDriverContextVariable;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Mono;

@Controller
public class TableroController {

    @Autowired
    private TableroRepository repository;

    @GetMapping("/")
    public String getAll(Model model) {
        IReactiveDataDriverContextVariable listaReactiva =
                new ReactiveDataDriverContextVariable(repository.findAll());
        model.addAttribute("tableros", listaReactiva);
        return "index";
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
