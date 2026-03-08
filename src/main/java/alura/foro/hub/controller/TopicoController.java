package alura.foro.hub.controller;


import alura.foro.hub.domain.topico.DatosDetalleTopico;
import alura.foro.hub.domain.topico.DatosRegistrarTopico;
import alura.foro.hub.domain.topico.Topico;
import alura.foro.hub.domain.topico.TopicoRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;


    @Transactional
    @PostMapping
    public ResponseEntity resgitrarTopico(@RequestBody @Valid DatosRegistrarTopico datos, UriComponentsBuilder uriP){
        var topico = new Topico(datos);

        repository.save(topico);

        var uri = UriComponentsBuilder.fromPath("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosDetalleTopico(topico));
    }

    @GetMapping("/{id}")
    public ResponseEntity detallar(@PathVariable Long id){
        var topico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DatosDetalleTopico(topico));
    }

}
